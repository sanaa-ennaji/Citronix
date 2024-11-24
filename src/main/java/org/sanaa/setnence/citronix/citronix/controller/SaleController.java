package org.sanaa.setnence.citronix.citronix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.SaleCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.SaleResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.SaleUpdateDTO;
import org.sanaa.setnence.citronix.citronix.service.Interfaces.SaleServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sales")
@Validated
@RequiredArgsConstructor
public class SaleController {

    private final SaleServiceI saleService;


    @PostMapping
    public ResponseEntity<SaleResponseDTO> createSale(@Valid @RequestBody SaleCreateDTO createDTO) {
        SaleResponseDTO responseDTO = saleService.create(createDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> updateSale(@PathVariable Long id,
                                                      @Valid @RequestBody SaleUpdateDTO updateDTO) {
        SaleResponseDTO responseDTO = saleService.update(id, updateDTO);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getSaleById(@PathVariable Long id) {
        Optional<SaleResponseDTO> responseDTO = saleService.findById(id);
        return responseDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales() {
        List<SaleResponseDTO> sales = saleService.findAll();
        return ResponseEntity.ok(sales);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}