package com.mortality.service.impl;

import com.mortality.model.Country;
import com.mortality.repository.CountryRepository;
import com.mortality.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
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
