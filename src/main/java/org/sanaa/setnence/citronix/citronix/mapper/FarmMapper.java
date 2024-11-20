package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmMapper extends GenericMapper<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> {

    @Override
    @Mapping(target = "fields", ignore = true)
    Farm toEntity(FarmCreateDTO createDTO);

    @Override
    @Mapping(target = "fields", source = "fields")
    FarmResponseDTO toDTO(Farm entity);

    @Override
    List<FarmResponseDTO> toDTOs(List<Farm> entities);

    @Override
    void updateEntityFromDTO(FarmUpdateDTO updateDTO, @MappingTarget Farm entity);
}
