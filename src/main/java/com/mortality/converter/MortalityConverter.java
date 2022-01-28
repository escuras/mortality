package com.mortality.converter;

import com.mortality.dto.MortalityDto;
import com.mortality.model.Country;
import com.mortality.model.Mortality;
import org.springframework.core.convert.converter.Converter;

public class MortalityConverter implements Converter<MortalityDto, Mortality> {

    @Override
    public Mortality convert(MortalityDto source) {
        Mortality mortality = new Mortality();
        mortality.setMortality(source.getMortality());
        mortality.setCountry(buildCountry(source.getCountryId()));
        mortality.setSex(source.getSex());
        mortality.setYear(source.getYear());
        return mortality;
    }

    private Country buildCountry(Long id) {
        Country country = new Country();
        country.setId(id);
        return country;
    }
}
