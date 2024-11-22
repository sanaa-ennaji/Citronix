package org.sanaa.setnence.citronix.citronix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.TreeCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.TreeResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.TreeUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Tree;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TreeMpper extends GenericMapper<Tree, TreeCreateDTO, TreeUpdateDTO, TreeResponseDTO> {
    @Override
    Tree toEntity(TreeCreateDTO createDTO);

    @Override
    TreeResponseDTO toDTO(Tree entity);

    @Override
    List<TreeResponseDTO> toDTOs(List<Tree> entities);

    @Override
    void updateEntityFromDTO(TreeUpdateDTO updateDTO, @MappingTarget Tree entity);
}
