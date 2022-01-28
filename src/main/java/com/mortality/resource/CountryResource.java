package com.mortality.resource;


import com.mortality.assembler.CountryDtoAssembler;
import com.mortality.assembler.MortalityDtoAssembler;
import com.mortality.dto.CountryDto;
import com.mortality.dto.ResourceDto;
import com.mortality.model.Country;
import com.mortality.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryService countryService;
    private final ConversionService conversionService;
    private final CountryDtoAssembler countryDtoAssembler;

    @GetMapping("")
    public List<ResourceDto> getCountries() {
        return countryService.getAll().stream()
                .map(e -> countryDtoAssembler.toModel(conversionService.convert(e, CountryDto.class))).collect(Collectors.toList());
    }

    @PostMapping
    public ResourceDto save(@RequestBody CountryDto countryDto) {
        Country country = conversionService.convert(countryDto, Country.class);
        return countryDtoAssembler.toModel(conversionService.convert(countryService.save(country), CountryDto.class));
    }
}
