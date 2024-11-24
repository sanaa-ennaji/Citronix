package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.transaction.Transactional;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.SaleCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.SaleResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.SaleUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Sale;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.SaleRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestServiceI;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.SaleServiceI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SaleService extends GenericService<Sale, SaleCreateDTO, SaleUpdateDTO, SaleResponseDTO> implements SaleServiceI {

    private final SaleRepository saleRepository;
    private final HarvestServiceI harvestService;

    public SaleService(GenericMapper<Sale, SaleCreateDTO, SaleUpdateDTO, SaleResponseDTO> mapper,
                       JpaRepository<Sale, Long> repository,
                       SaleRepository saleRepository,
                       HarvestServiceI harvestService) {
        super(mapper, repository);
        this.saleRepository = saleRepository;
        this.harvestService = harvestService;
    }

    @Override
    public SaleResponseDTO create(SaleCreateDTO createDTO) {
        validateSale(createDTO);
        return super.create(createDTO);
    }

    @Override
    public SaleResponseDTO update(Long id, SaleUpdateDTO updateDTO) {
        validateSale(updateDTO);
        return super.update(id, updateDTO);
    }

    private void validateSale(SaleCreateDTO createDTO) {
        HarvestResponseDTO harvest = harvestService.findById(createDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + createDTO.getHarvestId()));
    }

    private void validateSale(SaleUpdateDTO updateDTO) {
        HarvestResponseDTO harvest = harvestService.findById(updateDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + updateDTO.getHarvestId()));
    }
}
