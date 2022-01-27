package com.mortality.service;

import com.mortality.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();
    Country save(Country country);
    Country getOne(Long id);
    void delete(Long id);

}
