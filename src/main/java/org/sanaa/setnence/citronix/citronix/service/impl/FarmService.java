package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.exception.CustomException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.FarmServiceI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class FarmService extends GenericService<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> implements FarmServiceI {

    public FarmService(GenericMapper<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> mapper, JpaRepository<Farm, Long> repository) {
        super(mapper, repository);
    }
    @Override
    public  FarmResponseDTO create(@Valid FarmCreateDTO createDTO) {
        validateFarmCreate(createDTO);
        try {
            return super.create(createDTO);
        } catch (EntityNotFoundException e) {
            throw new CustomException("Farm could not be created");
        }

    }

    @Override
    public FarmResponseDTO update(Long id, @Valid HarvestUpdateDTO updateDTO) {
        return super.update(id, updateDTO);
    }

    private void validateFarmCreate(FarmCreateDTO createDTO) {
        if (createDTO.getArea() <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0.");
        }
    }
}

