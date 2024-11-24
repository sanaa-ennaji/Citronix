package org.sanaa.setnence.citronix.citronix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.TreeCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.TreeResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.TreeUpdateDTO;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.TreeServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trees")
@Validated
@RequiredArgsConstructor
public class TreeController {

    private final TreeServiceI treeService;

    @PostMapping
    public ResponseEntity<TreeResponseDTO> createTree(@Valid @RequestBody TreeCreateDTO createDTO) {
        TreeResponseDTO response = treeService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> updateTree(
            @PathVariable Long id,
            @Valid @RequestBody TreeUpdateDTO updateDTO) {
        TreeResponseDTO response = treeService.update(id, updateDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> getTreeById(@PathVariable Long id) {
        return treeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
    }

    @GetMapping
    public ResponseEntity<List<TreeResponseDTO>> getAllTrees() {
        List<TreeResponseDTO> trees = treeService.findAll();
        return ResponseEntity.ok(trees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Long id) {
        treeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
