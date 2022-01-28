package com.mortality.assembler;

import com.mortality.dto.MortalityDto;
import com.mortality.dto.ResourceDto;
import com.mortality.resource.MortalityResource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MortalityDtoAssembler implements RepresentationModelAssembler<MortalityDto, ResourceDto> {

    @Override
    public ResourceDto toModel(MortalityDto entity) {
        entity.add(linkTo(methodOn(MortalityResource.class).save(entity)).withSelfRel());
        return entity;
    }

    @Override
    public CollectionModel<ResourceDto> toCollectionModel(Iterable<? extends MortalityDto> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
