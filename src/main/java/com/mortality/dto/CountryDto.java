package com.mortality.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto extends ResourceDto{

    private Long id;
    private String name;
    private String countryAcronym;
    private int population;

}
