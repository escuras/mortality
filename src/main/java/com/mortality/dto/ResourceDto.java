package com.mortality.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ResourceDto extends RepresentationModel<MortalityDto> {
}
