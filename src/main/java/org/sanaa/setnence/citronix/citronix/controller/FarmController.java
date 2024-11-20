package org.sanaa.setnence.citronix.citronix.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.service.impl.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/farms")
@Validated
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService ;

    public ResponseEntity<FarmResponseDTO> create (@Valid @RequestBody FarmCreateDTO createDTO){
        FarmResponseDTO farmResponseDTO = farmService.create(createDTO);
        return new ResponseEntity<>(farmResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmResponseDTO> update(
            @PathVariable @NotNull Long id,
            @Valid @RequestBody FarmUpdateDTO updateDTO
    ) {
        FarmResponseDTO farmResponseDTO = farmService.update(id, updateDTO);
        return new ResponseEntity<>(farmResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmResponseDTO> getFarmById(@PathVariable Long id) {
        return farmService.findById(id)
                .map(farmResponseDTO -> new ResponseEntity<>(farmResponseDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<FarmResponseDTO>> getAllFarms() {
        List<FarmResponseDTO> farms = farmService.findAll();
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
