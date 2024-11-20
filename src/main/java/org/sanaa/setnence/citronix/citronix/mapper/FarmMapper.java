package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.factory.Mappers;

public class FarmMapper {


    FarmMapper INSTANCE = Mappers.getMapper(FarmMapper.class);

    @Mapping(source = "parentFarmId", target = "parentFarm.id")
    Farm toEntity(FarmDTO farmDTO);


    @Mapping(source = "parentFarm.id", target = "parentFarmId")
    FarmDTO toDto(Farm farm);

}
