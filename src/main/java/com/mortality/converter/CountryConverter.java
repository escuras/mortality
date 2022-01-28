package com.mortality.converter;

import com.mortality.dto.CountryDto;
import com.mortality.model.Country;
import org.springframework.core.convert.converter.Converter;

public class CountryConverter implements Converter<CountryDto, Country> {

    @Override
    public Country convert(CountryDto source) {
        Country country = new Country();
        country.setId(source.getId());
        country.setCountryAcronym(source.getCountryAcronym());
        country.setName(source.getName());
        country.setPopulation(source.getPopulation());
        return country;
    }
}
