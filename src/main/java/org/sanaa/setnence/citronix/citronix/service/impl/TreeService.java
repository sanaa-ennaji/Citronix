package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.TreeCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.TreeResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.TreeUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Tree;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.TreeRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.FieldServiceI;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.TreeServiceI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class TreeService  extends GenericService<Tree, TreeCreateDTO, TreeUpdateDTO, TreeResponseDTO> implements TreeServiceI {

    private final TreeRepository treeRepository;
    private final FieldServiceI fieldService;

    public TreeService(GenericMapper<Tree, TreeCreateDTO, TreeUpdateDTO, TreeResponseDTO> mapper,
                       JpaRepository<Tree, Long> repository,
                       TreeRepository treeRepository,
                       FieldServiceI fieldService) {
        super(mapper, repository);
        this.treeRepository = treeRepository;
        this.fieldService = fieldService;
    }

    @Override
    public TreeResponseDTO create(TreeCreateDTO createDTO) {
        validateTree(createDTO);
        return super.create(createDTO);
    }

    @Override
    public TreeResponseDTO update(Long id, @Valid HarvestUpdateDTO updateDTO) {
        validateTree(updateDTO);
        return super.update(id, updateDTO);
    }

    private void validateTree(Object treeDTO) {
        if (treeDTO instanceof TreeCreateDTO createDTO) {
            validatePlantingPeriod(createDTO.getPlantingDate());
            validateTreeAge(createDTO.getPlantingDate());
            validateFieldDensity(createDTO.getFieldId());
        } else if (treeDTO instanceof TreeUpdateDTO updateDTO) {
            validateFieldDensity(updateDTO.getFieldId());
        }
    }

    private void validatePlantingPeriod(LocalDate plantingDate) {
        int month = plantingDate.getMonthValue();
        if (month < 3 || month > 5) {
            throw new IllegalArgumentException("Trees can only be planted between March and May.");
        }
    }

    private void validateTreeAge(LocalDate plantingDate) {
        int age = LocalDate.now().getYear() - plantingDate.getYear();
        if (age > 20) {
            throw new IllegalArgumentException("A tree cannot be productive beyond 20 years.");
        }
    }

    private void validateFieldDensity(Long fieldId) {
        FieldResponseDTO field = fieldService.findById(fieldId)
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + fieldId));

        double maxTreesPerSquareMeter = 0.1;
        long treeCount = treeRepository.countByFieldId(fieldId);

        if (treeCount + 1 > field.getArea() * maxTreesPerSquareMeter) {
            throw new IllegalArgumentException("Field exceeds the maximum density of 100 trees per hectare.");
        }
    }
}
