package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmMapper extends GenericMapper<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> {

    @Override
    @Mapping(target = "fields", ignore = true) // Avoiding potential recursive mapping issues
    Farm toEntity(FarmCreateDTO createDTO);

    @Override
    @Mapping(target = "fields", source = "fields")
    FarmResponseDTO toDTO(Farm entity);

    @Override
    List<FarmResponseDTO> toDTOs(List<Farm> entities);

    @Override
    void updateEntityFromDTO(FarmUpdateDTO updateDTO, @MappingTarget Farm entity);
}
