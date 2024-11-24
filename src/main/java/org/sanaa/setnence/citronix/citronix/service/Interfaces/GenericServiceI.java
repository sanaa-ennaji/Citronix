package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericServiceI<Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    ResponseDTO create(CreateDTO createDTO);

    ResponseDTO update(Long id, HarvestUpdateDTO updateDTO);

    Optional<ResponseDTO> findById(Long id);

    List<ResponseDTO> findAll();

    void delete(Long id);
}

