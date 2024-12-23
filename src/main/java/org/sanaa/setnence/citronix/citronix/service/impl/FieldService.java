package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.transaction.Transactional;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FieldCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FieldUpdateDTO;

import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.FarmRepository;
import org.sanaa.setnence.citronix.citronix.repository.FieldRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.FieldServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FieldService extends GenericService<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> implements FieldServiceI {

    private final FieldRepository fieldRepository;
    private final FarmRepository farmRepository;

    public FieldService(GenericMapper<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> fieldMapper,
                        FieldRepository fieldRepository,
                        FarmRepository farmRepository) {
        super(fieldMapper, fieldRepository);
        this.fieldRepository = fieldRepository;
        this.farmRepository = farmRepository;
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
        Farm farm = farmRepository.findById(createDTO.getFarmId()).orElseThrow(() ->
                new EntityNotFoundException("Farm not found"));

        if (createDTO.getArea() < 0.1) {
            throw new IllegalArgumentException("Field area must be at least 0.1 hectare.");
        }

        List<Field> fields = fieldRepository.findByFarmId(createDTO.getFarmId());

        double totalFieldsArea = fields.stream()
                .mapToDouble(Field::getArea)
                .sum();

        long fieldCount = fields.size();

        if (createDTO.getArea() + totalFieldsArea > farm.getArea()) {
            throw new IllegalArgumentException("The total area of fields in the farm cannot exceed the farm's total area.");
        }

        if (createDTO.getArea() > farm.getArea() * 0.5) {
            throw new IllegalArgumentException("Field area cannot exceed 50% of the total farm area.");
        }

        if (fieldCount >= 10) {
            throw new IllegalArgumentException("A farm cannot have more than 10 fields.");
        }
    }

    private void validateFieldUpdate(FieldUpdateDTO updateDTO) {
        validateFieldCreate(new FieldCreateDTO(updateDTO.getName(), updateDTO.getArea(), updateDTO.getFarmId()));
    }
}
