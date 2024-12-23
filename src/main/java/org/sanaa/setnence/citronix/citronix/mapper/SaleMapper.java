package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.SaleCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.SaleResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.SaleUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Sale;


import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper extends GenericMapper<Sale, SaleCreateDTO, SaleUpdateDTO, SaleResponseDTO> {

    @Mapping(target = "harvest.id", source = "harvestId")
    Sale toEntity(SaleCreateDTO createDTO);

    @Mapping(target = "harvestId", source = "harvest.id")
    SaleResponseDTO toDTO(Sale entity);

    @Override
    List<SaleResponseDTO> toDTOs(List<Sale> entities);

    @Override
    void updateEntityFromDTO(SaleUpdateDTO updateDTO, @MappingTarget Sale entity);
}

