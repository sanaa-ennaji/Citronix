package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper <Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity toEntity(CreateDTO createDTO);

    ResponseDTO toDTO(Entity entity);

    List<ResponseDTO> toDTOs(List<Entity> entities);

    void updateEntityFromDTO(UpdateDTO updateDTO, @MappingTarget Entity entity);
}
