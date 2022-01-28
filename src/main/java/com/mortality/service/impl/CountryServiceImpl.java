package com.mortality.service.impl;

import com.mortality.model.Country;
import com.mortality.repository.CountryRepository;
import com.mortality.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional
    public Country save(Country country) {
        Optional<Country> countryOptional = countryRepository.findByName(country.getName());

        // if present update
        if (countryOptional.isPresent()) {
            Country dbCountry = countryOptional.get();
            dbCountry.setCountryAcronym(country.getCountryAcronym());
            dbCountry.setPopulation(country.getPopulation());
            return dbCountry;
        }

        // else create
        return countryRepository.save(country);
    }

    @Override
    public Country getOne(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
