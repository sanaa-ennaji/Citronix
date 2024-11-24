package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.TreeCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.TreeResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.TreeUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Tree;

public interface TreeServiceI  extends GenericServiceI<Tree, TreeCreateDTO, TreeUpdateDTO, TreeResponseDTO>{
}
