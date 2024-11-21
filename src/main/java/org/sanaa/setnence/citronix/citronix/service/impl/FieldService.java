package org.sanaa.setnence.citronix.citronix.service.impl;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FieldCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FieldUpdateDTO;

import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.FieldRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.FieldServiceI;


public class FieldService extends GenericService<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> implements FieldServiceI {

    private final FarmService farmService;
    private final FieldRepository fieldRepository;


    public FieldService(GenericMapper<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> fieldMapper,
                        FieldRepository fieldRepository,
                        FarmService farmService) {
        super(fieldMapper, fieldRepository);
        this.farmService = farmService;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public FieldResponseDTO create(FieldCreateDTO createDTO) {
        validateFieldCreate(createDTO);
        return super.create(createDTO);
    }

    @Override
    public FieldResponseDTO update(Long id, FieldUpdateDTO updateDTO) {
        validateFieldUpdate(updateDTO);
        return super.update(id, updateDTO);
    }


    private void validateFieldCreate(FieldCreateDTO createDTO) {
        FarmResponseDTO farm = farmService.findById(createDTO.getFarmId())
                .orElseThrow(() -> new EntityNotFoundException("Farm not found"));

        if (createDTO.getArea() < 0.1) {
            throw new IllegalArgumentException("Field area must be at least 0.1 hectare.");
        }

        double totalFarmArea = farm.getArea();
        if (createDTO.getArea() > totalFarmArea * 0.5) {
            throw new IllegalArgumentException("Field area cannot exceed 50% of the total farm area.");
        }

        double totalFieldsArea = fieldRepository.sumAreaByFarmId(createDTO.getFarmId());
        if (totalFieldsArea + createDTO.getArea() > totalFarmArea) {
            throw new IllegalArgumentException("The total area of fields in the farm cannot exceed the farm's total area.");
        }

        long fieldCount = fieldRepository.countByFarmId(createDTO.getFarmId());
        if (fieldCount >= 10) {
            throw new IllegalArgumentException("A farm cannot have more than 10 fields.");
        }
    }


    private void validateFieldUpdate(FieldUpdateDTO updateDTO) {
        validateFieldCreate(new FieldCreateDTO(updateDTO.getName(), updateDTO.getArea(), updateDTO.getFarmId())); // Reuse the creation logic for updates
    }
}
