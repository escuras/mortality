package com.mortality.resource;


import com.mortality.model.Country;
import com.mortality.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryService countryService;

    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getAll();
    }

    @PostMapping
    public Country save(@RequestBody Country country) {
        return countryService.save(country);
    }
}
