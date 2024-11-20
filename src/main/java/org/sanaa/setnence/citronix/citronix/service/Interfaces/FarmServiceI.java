package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;

import java.util.List;

public interface FarmServiceI {

    FarmResponseDTO  create (FarmCreateDTO farmCreateDTO);
    FarmResponseDTO update (Long id , FarmUpdateDTO farmUpdateDTO);
    FarmResponseDTO getById ( Long id);
    List<FarmResponseDTO>  getAll ();
    void delete (long id) ;

}
