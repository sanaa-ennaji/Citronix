package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestDetailResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestDetailUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.embedded.EmbeddedHarvestDetail;

import java.util.List;
import java.util.Optional;

public interface HarvestDetailServiceI {
    HarvestDetailResponseDTO create(HarvestDetailCreateDTO createDTO);
    HarvestDetailResponseDTO update(EmbeddedHarvestDetail id, HarvestDetailUpdateDTO updateDTO);
    Optional<HarvestDetailResponseDTO> findById(EmbeddedHarvestDetail id);
    List<HarvestDetailResponseDTO> findAll();
    void delete(EmbeddedHarvestDetail id);
}
