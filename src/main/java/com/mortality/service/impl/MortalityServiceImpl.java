package com.mortality.service.impl;

import com.mortality.domain.MortalityTax;
import com.mortality.domain.SexEnum;
import com.mortality.model.Country;
import com.mortality.model.Mortality;
import com.mortality.repository.CountryRepository;
import com.mortality.repository.MortalityRepository;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MortalityServiceImpl implements MortalityService {

    private final MortalityRepository mortalityRepository;
    private final CountryRepository countryRepository;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public List<MortalityTax> getMortalityTaxes(int year) {
        List<Country> countries = countryRepository.findAll();
        List<MortalityTax> values = new ArrayList<>();
        countries.forEach(country -> {
            MortalityTax mortalityTax = new MortalityTax();
            mortalityTax.setCountry(country.getName());
            Optional<Mortality> optionalFemaleMortality = mortalityRepository
                    .findByYearAndCountryIdAndSex(year, country.getId(), SexEnum.FEMALE);
            Optional<Mortality> optionalMaleMortality = mortalityRepository
                    .findByYearAndCountryIdAndSex(year, country.getId(), SexEnum.MALE);

            if (optionalFemaleMortality.isPresent()) {
                double tax = calculateTax(country.getPopulation(), optionalFemaleMortality.get().getMortality());
                mortalityTax.setFemaleTax(df.format(tax));
            }

            if (optionalMaleMortality.isPresent()) {
                double tax = calculateTax(country.getPopulation(), optionalMaleMortality.get().getMortality());
                mortalityTax.setMaleTax(df.format(tax));
            }

            values.add(mortalityTax);
        });
        return values;
    }

    @Override
    public Mortality save(Mortality mortality) {
        Optional<Mortality> dbData = mortalityRepository
                .findByYearAndCountryIdAndSex(mortality.getYear(), mortality.getCountry().getId(), mortality.getSex());

        if(dbData.isPresent()) {
            int value = mortality.getMortality();
            mortality = dbData.get();
            mortality.setMortality(value);
        }
        return mortalityRepository.save(mortality);
    }

    private double calculateTax(int population, int mortality) {
        return mortality * 1000.0 / population;
    }
}
