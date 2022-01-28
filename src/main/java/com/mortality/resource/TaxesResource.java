package com.mortality.resource;

import com.mortality.domain.MortalityTax;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/taxes")
@RequiredArgsConstructor
public class TaxesResource {

    private final MortalityService mortalityService;

    @GetMapping(value = "/{year}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<List<MortalityTax>> getMortalityTaxes(@PathVariable Integer year) {
        return ResponseEntity.ok(mortalityService.getMortalityTaxes(year));
    }
}
