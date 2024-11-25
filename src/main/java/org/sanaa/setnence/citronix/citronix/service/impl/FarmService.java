package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.FarmSearchDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.exception.CustomException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.FarmRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.FarmServiceI;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FarmService extends GenericService<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> implements FarmServiceI {

    private final FarmRepository farmRepository;

    public FarmService(GenericMapper<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> mapper,
                       JpaRepository<Farm, Long> repository,
                       FarmRepository farmRepository) {
        super(mapper, repository);
        this.farmRepository = farmRepository;
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

    public List<FarmResponseDTO> search(FarmSearchDTO searchDTO) {
        Specification<Farm> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchDTO.getName() != null && !searchDTO.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + searchDTO.getName() + "%"));
            }
            if (searchDTO.getLocation() != null && !searchDTO.getLocation().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("location"), "%" + searchDTO.getLocation() + "%"));
            }
            if (searchDTO.getStartDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createDate"), searchDTO.getStartDate()));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Farm> farms = farmRepository.findAll(specification);
        return mapper.toDTOs(farms);
    }

    @Override
    public FarmResponseDTO update(Long id, @Valid FarmUpdateDTO updateDTO) {
        return super.update(id, updateDTO);
    }

    private void validateFarmCreate(FarmCreateDTO createDTO) {
        if (createDTO.getArea() <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0.");
        }
    }
}

