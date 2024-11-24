package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import jakarta.validation.Valid;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface GenericServiceI<Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    ResponseDTO create(CreateDTO createDTO);

    ResponseDTO update(Long id, @Valid HarvestUpdateDTO updateDTO);

    Optional<ResponseDTO> findById(Long id);

    List<ResponseDTO> findAll();

    void delete(Long id);
}

