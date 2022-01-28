package com.mortality.converter;

import com.mortality.dto.CountryDto;
import com.mortality.model.Country;
import org.springframework.core.convert.converter.Converter;

public class CountryDtoConverter implements Converter<Country, CountryDto> {

    @Override
    public CountryDto convert(Country source) {
        return CountryDto.builder()
                .countryAcronym(source.getCountryAcronym())
                .name(source.getName())
                .population(source.getPopulation())
                .id(source.getId())
                .build();
    }
}
