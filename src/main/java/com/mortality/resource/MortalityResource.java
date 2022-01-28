package com.mortality.resource;

import com.mortality.assembler.MortalityDtoAssembler;
import com.mortality.dto.MortalityDto;
import com.mortality.dto.ResourceDto;
import com.mortality.model.Mortality;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mortality")
@RequiredArgsConstructor
public class MortalityResource {

    private final MortalityService mortalityService;
    private final ConversionService conversionService;
    private final MortalityDtoAssembler mortalityDtoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceDto save(@RequestBody MortalityDto mortalityDto) {
        Mortality mortality = conversionService.convert(mortalityDto, Mortality.class);
        return mortalityDtoAssembler.toModel(conversionService.convert(mortalityService.save(mortality), MortalityDto.class));
    }

}
