package org.sanaa.setnence.citronix.citronix.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FieldCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FieldUpdateDTO;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.service.impl.FieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fields")
@Validated
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @PostMapping
    public ResponseEntity<FieldResponseDTO> createField(@RequestBody @Valid FieldCreateDTO createDTO) {
        FieldResponseDTO responseDTO = fieldService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> updateField(
            @PathVariable @Positive(message = "Field ID must be positive") Long id,
            @RequestBody @Valid FieldUpdateDTO updateDTO) {
        FieldResponseDTO responseDTO = fieldService.update(id, updateDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> getFieldById(
            @PathVariable @Positive(message = "Field ID must be positive") Long id) {
        return fieldService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Field not found with ID: " + id));
    }


    @GetMapping
    public ResponseEntity<List<FieldResponseDTO>> getAllFields() {
        List<FieldResponseDTO> fields = fieldService.findAll();
        return ResponseEntity.ok(fields);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(
            @PathVariable @Positive(message = "Field ID must be positive") Long id) {
        fieldService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
