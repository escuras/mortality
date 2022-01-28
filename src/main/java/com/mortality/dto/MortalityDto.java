package com.mortality.dto;


import com.mortality.domain.SexEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortalityDto extends ResourceDto {

    private Long countryId;
    private SexEnum sex;
    private Long mortality;
    private int year;

}
