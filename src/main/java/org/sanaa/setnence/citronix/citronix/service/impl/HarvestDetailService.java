package org.sanaa.setnence.citronix.citronix.service.impl;

import jakarta.transaction.Transactional;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestDetailResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestDetailUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.HarvestDetail;
import org.sanaa.setnence.citronix.citronix.entity.embedded.EmbeddedHarvestDetail;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.HarvestDetailRepository;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestDetailServiceI;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestServiceI;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.TreeServiceI;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HarvestDetailService implements HarvestDetailServiceI {

    private final HarvestDetailRepository harvestDetailRepository;
    private final HarvestServiceI harvestService;
    private final TreeServiceI treeService;
    private final GenericMapper<HarvestDetail, HarvestDetailCreateDTO, HarvestDetailUpdateDTO, HarvestDetailResponseDTO> harvestDetailMapper;

    public HarvestDetailService(GenericMapper<HarvestDetail, HarvestDetailCreateDTO, HarvestDetailUpdateDTO, HarvestDetailResponseDTO> harvestDetailMapper,
                                HarvestDetailRepository harvestDetailRepository,
                                HarvestServiceI harvestService,
                                TreeServiceI treeService) {
        this.harvestDetailMapper = harvestDetailMapper;
        this.harvestDetailRepository = harvestDetailRepository;
        this.harvestService = harvestService;
        this.treeService = treeService;
    }

    @Override
    public HarvestDetailResponseDTO create(HarvestDetailCreateDTO createDTO) {
        validateHarvestDetail(createDTO);
        HarvestDetail harvestDetail = harvestDetailMapper.toEntity(createDTO);
        harvestDetail = harvestDetailRepository.save(harvestDetail);
        return harvestDetailMapper.toDTO(harvestDetail);
    }

    @Override
    public HarvestDetailResponseDTO update(EmbeddedHarvestDetail id, HarvestDetailUpdateDTO updateDTO) {
        validateHarvestDetail(updateDTO);
        Optional<HarvestDetail> optionalHarvestDetail = harvestDetailRepository.findById(id);
        if (optionalHarvestDetail.isEmpty()) {
            throw new EntityNotFoundException("HarvestDetail not found with id: " + id);
        }
        HarvestDetail harvestDetail = optionalHarvestDetail.get();
        harvestDetailMapper.updateEntityFromDTO(updateDTO, harvestDetail);
        harvestDetail = harvestDetailRepository.save(harvestDetail);
        return harvestDetailMapper.toDTO(harvestDetail);
    }

    @Override
    public Optional<HarvestDetailResponseDTO> findById(EmbeddedHarvestDetail id) {
        return harvestDetailRepository.findById(id).map(harvestDetailMapper::toDTO);
    }

    @Override
    public List<HarvestDetailResponseDTO> findAll() {
        List<HarvestDetail> harvestDetails = harvestDetailRepository.findAll();
        return harvestDetailMapper.toDTOs(harvestDetails);
    }

    @Override
    public void delete(EmbeddedHarvestDetail id) {
        if (!harvestDetailRepository.existsById(id)) {
            throw new EntityNotFoundException("HarvestDetail not found with id: " + id);
        }
        harvestDetailRepository.deleteById(id);
    }

    private void validateHarvestDetail(Object harvestDetailDTO) {
        if (harvestDetailDTO instanceof HarvestDetailCreateDTO) {
            HarvestDetailCreateDTO createDTO = (HarvestDetailCreateDTO) harvestDetailDTO;
            validateHarvest(createDTO.getHarvestId());
            validateTree(createDTO.getTreeId());
            validateQuantity(createDTO.getQuantity());
        } else if (harvestDetailDTO instanceof HarvestDetailUpdateDTO) {
            HarvestDetailUpdateDTO updateDTO = (HarvestDetailUpdateDTO) harvestDetailDTO;
            validateQuantity(updateDTO.getQuantity());
        }
    }

    private void validateHarvest(Long harvestId) {
        harvestService.findById(harvestId).orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + harvestId));
    }

    private void validateTree(Long treeId) {
        treeService.findById(treeId).orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + treeId));
    }

    private void validateQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
    }
}



