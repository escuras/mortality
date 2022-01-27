package com.mortality.resource;

import com.mortality.model.Mortality;
import com.mortality.service.MortalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mortality")
@RequiredArgsConstructor
public class MortalityResource {

    private final MortalityService mortalityService;

    @PostMapping
    public Mortality save(@RequestBody Mortality mortality) {
        return mortalityService.save(mortality);
    }

}
