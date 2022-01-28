package com.mortality.converter;

import com.mortality.dto.MortalityDto;
import com.mortality.model.Mortality;
import org.springframework.core.convert.converter.Converter;

public class MortalityDtoConverter implements Converter<Mortality, MortalityDto> {

    @Override
    public MortalityDto convert(Mortality source) {
        return MortalityDto.builder()
                .mortality(source.getMortality())
                .countryId(source.getCountry().getId())
                .sex(source.getSex())
                .year(source.getYear())
                .build();
    }
}
