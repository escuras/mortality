package com.mortality.assembler;

import com.mortality.dto.CountryDto;
import com.mortality.dto.ResourceDto;
import com.mortality.resource.CountryResource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryDtoAssembler implements RepresentationModelAssembler<CountryDto, ResourceDto> {

    @Override
    public ResourceDto toModel(CountryDto entity) {
        entity.add(linkTo(methodOn(CountryResource.class).getCountries()).withRel("Get all countries"));
        return entity;
    }

    @Override
    public CollectionModel<ResourceDto> toCollectionModel(Iterable<? extends CountryDto> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
