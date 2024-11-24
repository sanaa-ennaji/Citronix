package org.sanaa.setnence.citronix.citronix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestDetailCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestDetailResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestDetailUpdateDTO;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestDetailServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harvest-details")
@Validated
@RequiredArgsConstructor
public class HarvestDetailController {

    private final HarvestDetailServiceI harvestDetailService;

    @PostMapping
    public ResponseEntity<HarvestDetailResponseDTO> createHarvestDetail(@RequestBody @Valid HarvestDetailCreateDTO createDTO) {
        HarvestDetailResponseDTO createdHarvestDetail = harvestDetailService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHarvestDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestDetailResponseDTO> updateHarvestDetail(@PathVariable Long id, @RequestBody @Valid HarvestDetailUpdateDTO updateDTO) {
        HarvestDetailResponseDTO updatedHarvestDetail = harvestDetailService.update(id, updateDTO);
        return ResponseEntity.ok(updatedHarvestDetail);
    }


    @GetMapping("/{id}")
    public ResponseEntity<HarvestDetailResponseDTO> getHarvestDetailById(@PathVariable Long id) {
        return harvestDetailService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<HarvestDetailResponseDTO>> getAllHarvestDetails() {
        List<HarvestDetailResponseDTO> harvestDetails = harvestDetailService.findAll();
        return ResponseEntity.ok(harvestDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvestDetail(@PathVariable Long id) {
        harvestDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

