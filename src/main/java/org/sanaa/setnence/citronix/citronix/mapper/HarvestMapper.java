package org.sanaa.setnence.citronix.citronix.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HarvestMapper extends GenericMapper<Harvest, HarvestCreateDTO, HarvestUpdateDTO, HarvestResponseDTO> {

    @Override
    Harvest toEntity(HarvestCreateDTO createDTO);

    @Override
    HarvestResponseDTO toDTO(Harvest entity);

    @Override
    List<HarvestResponseDTO> toDTOs(List<Harvest> entities);

    @Override
    void updateEntityFromDTO(HarvestUpdateDTO updateDTO, @MappingTarget Harvest entity);
}
