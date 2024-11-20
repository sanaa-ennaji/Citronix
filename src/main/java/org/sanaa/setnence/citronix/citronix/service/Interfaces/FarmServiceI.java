package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;



public interface FarmServiceI extends GenericServiceI<Farm, FarmCreateDTO , FarmUpdateDTO , FarmResponseDTO> {



}
