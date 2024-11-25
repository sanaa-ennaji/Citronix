package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.HarvestRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestServiceI;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.TreeServiceI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class HarvestService extends GenericService<Harvest, HarvestCreateDTO, HarvestUpdateDTO, HarvestResponseDTO> implements HarvestServiceI {

    private final HarvestRepository harvestRepository;
    private final TreeServiceI treeService;

    public HarvestService(GenericMapper<Harvest, HarvestCreateDTO, HarvestUpdateDTO, HarvestResponseDTO> mapper,
                          JpaRepository<Harvest, Long> repository,
                          HarvestRepository harvestRepository,
                          TreeServiceI treeService
    ) {
        super(mapper, repository);
        this.harvestRepository = harvestRepository;
        this.treeService = treeService;
    }

    @Override
    public HarvestResponseDTO create(HarvestCreateDTO createDTO) {
        validateHarvest(createDTO);
        if (createDTO.getTotalQuantity() == 0) {
            createDTO.setTotalQuantity(calculateTotalQuantity(createDTO.getDetails()));
        }
        return super.create(createDTO);
    }

    @Override
    public HarvestResponseDTO update(Long id, HarvestUpdateDTO updateDTO) {
        validateHarvest(updateDTO);
        if (updateDTO.getTotalQuantity() == 0) {
            updateDTO.setTotalQuantity(calculateTotalQuantity(updateDTO.getDetails()));
        }
        return super.update(id, updateDTO);
    }



    private void validateHarvest(Object harvestDTO) {
        if (harvestDTO instanceof HarvestCreateDTO) {
            HarvestCreateDTO createDTO = (HarvestCreateDTO) harvestDTO;
            validateSeason(createDTO.getSeason());
            validateHarvestDate(createDTO.getHarvestDate());
            validateTotalQuantity(createDTO.getTotalQuantity());
        } else if (harvestDTO instanceof HarvestUpdateDTO) {
            HarvestUpdateDTO updateDTO = (HarvestUpdateDTO) harvestDTO;
            validateTotalQuantity(updateDTO.getTotalQuantity());
        }
    }



    private void validateSeason(@NotNull(message = "Season must not be null.") Season season) {
        if (season == null) {
            throw new IllegalArgumentException("Season must be provided.");
        }
    }

    private void validateHarvestDate(@NotNull(message = "Harvest date must not be null.") LocalDate harvestDate) {
        if (harvestDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Harvest date cannot be in the future.");
        }
    }

    private void validateTotalQuantity(double totalQuantity) {
        if (totalQuantity < 0) {
            throw new IllegalArgumentException("Total quantity must be positive or zero.");
        }
    }


    private double calculateTotalQuantity(List<HarvestDetailCreateDTO> details) {
        if (details == null || details.isEmpty()) {
            return 0;
        }
        return details.stream()
                .mapToDouble(HarvestDetailCreateDTO::getQuantity)
                .sum();
    }
}
