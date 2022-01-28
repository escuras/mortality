package com.mortality.service.impl;

import com.mortality.domain.MortalityTax;
import com.mortality.domain.SexEnum;
import com.mortality.dto.MortalityDto;
import com.mortality.model.Country;
import com.mortality.model.Mortality;
import com.mortality.repository.CountryRepository;
import com.mortality.repository.MortalityRepository;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MortalityServiceImpl implements MortalityService {

    private final ConversionService conversionService;
    private final MortalityRepository mortalityRepository;
    private final CountryRepository countryRepository;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public List<MortalityTax> getMortalityTaxes(int year) {
        return countryRepository.findAll().stream()
                .map(country -> this.getMortalityTax(year, country))
                .collect(Collectors.toList());
    }

    private MortalityTax getMortalityTax(int year, Country country) {

        // initialize mortality tax
        MortalityTax mortalityTax = MortalityTax.builder()
                .country(country.getName())
                .femaleTax("0,00")
                .maleTax("0,00")
                .build();

        // get mortalities from datatbase
        Optional<Mortality> optionalFemaleMortality = mortalityRepository
                .findByYearAndCountryIdAndSex(year, country.getId(), SexEnum.FEMALE);
        Optional<Mortality> optionalMaleMortality = mortalityRepository
                .findByYearAndCountryIdAndSex(year, country.getId(), SexEnum.MALE);

        // fill female tax
        if (optionalFemaleMortality.isPresent()) {
            double tax = calculateTax(country.getPopulation(), optionalFemaleMortality.get().getMortality());
            mortalityTax.setFemaleTax(df.format(tax));
        }

        // fill male tax
        if (optionalMaleMortality.isPresent()) {
            double tax = calculateTax(country.getPopulation(), optionalMaleMortality.get().getMortality());
            mortalityTax.setMaleTax(df.format(tax));
        }

        return mortalityTax;
    }

    @Override
    @Transactional
    public Mortality save(Mortality mortality) {
        Optional<Mortality> dbData = mortalityRepository
                .findByYearAndCountryIdAndSex(mortality.getYear(), mortality.getCountry().getId(), mortality.getSex());

        // if present update
        if(dbData.isPresent()) {
            Long value = mortality.getMortality();
            Mortality dbMortality = dbData.get();
            dbMortality.setMortality(value);
            return dbMortality;
        }

        // not create
        return mortalityRepository.save(mortality);
    }

    private double calculateTax(int population, Long mortality) {
        return mortality * 1000.0 / population;
    }
}
