package org.sanaa.setnence.citronix.citronix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestResponseDTO;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.HarvestServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harvests")
@Validated
@RequiredArgsConstructor
public class HarvestController {

    private final HarvestServiceI harvestService;

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> createHarvest(@RequestBody @Valid HarvestCreateDTO createDTO) {
        HarvestResponseDTO createdHarvest = harvestService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHarvest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> updateHarvest(@PathVariable Long id, @RequestBody @Valid HarvestUpdateDTO updateDTO) {
        HarvestResponseDTO updatedHarvest = harvestService.update(id, updateDTO);
        return ResponseEntity.ok(updatedHarvest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> getHarvestById(@PathVariable Long id) {
        return harvestService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<HarvestResponseDTO>> getAllHarvests() {
        List<HarvestResponseDTO> harvests = harvestService.findAll();
        return ResponseEntity.ok(harvests);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvest(@PathVariable Long id) {
        harvestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
