package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FieldCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FieldUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Field;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FieldMapper extends GenericMapper<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> {

    @Override
    Field toEntity(FieldCreateDTO createDTO);

    @Override
    FieldResponseDTO toDTO(Field entity);

    @Override
    List<FieldResponseDTO> toDTOs(List<Field> entities);

    @Override
    void updateEntityFromDTO(FieldUpdateDTO updateDTO, @MappingTarget Field entity);

}
