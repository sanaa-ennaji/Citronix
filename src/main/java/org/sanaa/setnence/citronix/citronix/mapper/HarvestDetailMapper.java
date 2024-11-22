package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestDetailResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestDetailUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.HarvestDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HarvestDetailMapper extends GenericMapper<HarvestDetail, HarvestDetailCreateDTO, HarvestDetailUpdateDTO, HarvestDetailResponseDTO> {
    @Override
    HarvestDetail toEntity(HarvestDetailCreateDTO createDTO);

    @Override
    HarvestDetailResponseDTO toDTO(HarvestDetail entity);

    @Override
    List<HarvestDetailResponseDTO> toDTOs(List<HarvestDetail> entities);

    @Override
    void updateEntityFromDTO(HarvestDetailUpdateDTO updateDTO, @MappingTarget HarvestDetail entity);
}
