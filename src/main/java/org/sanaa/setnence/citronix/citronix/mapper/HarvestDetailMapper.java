package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestDetailResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestDetailUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.HarvestDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HarvestDetailMapper {

    @Mapping(target = "harvest.id", source = "harvestId")
    @Mapping(target = "tree.id", source = "treeId")
    HarvestDetail toEntity(HarvestDetailCreateDTO createDTO);

    @Mapping(target = "harvestId", source = "harvest.id")
    @Mapping(target = "treeId", source = "tree.id")
    HarvestDetailResponseDTO toDTO(HarvestDetail entity);

    List<HarvestDetailResponseDTO> toDTOs(List<HarvestDetail> entities);

    void updateEntityFromDTO(HarvestDetailUpdateDTO updateDTO, @MappingTarget HarvestDetail entity);
}



