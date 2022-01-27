package com.mortality.resource;

import com.mortality.domain.MortalityTax;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taxes")
@RequiredArgsConstructor
public class TaxesResource {

    private final MortalityService mortalityService;

    @GetMapping("/{year}")
    public List<MortalityTax> getCountries(@PathVariable Integer year) {
        return mortalityService.getMortalityTaxes(year);
    }
}
