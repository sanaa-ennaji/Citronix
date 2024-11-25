package org.sanaa.setnence.citronix.citronix.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FieldCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FieldResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FieldUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.FarmRepository;
import org.sanaa.setnence.citronix.citronix.repository.FieldRepository;
import org.sanaa.setnence.citronix.citronix.service.impl.FieldService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FieldServiceTest {

    @InjectMocks
    private FieldService fieldService;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private FarmRepository farmRepository;

    @Mock
    private GenericMapper<Field, FieldCreateDTO, FieldUpdateDTO, FieldResponseDTO> fieldMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   // testUpdate Field
    @Test
    void InvalidArea() {
        FieldUpdateDTO updateDTO = new FieldUpdateDTO("Field1", 0.05, 1L);
        when(farmRepository.findById(1L)).thenReturn(Optional.of(new Farm(1L, "Farm1", "Location1", 10.0, LocalDate.now(), new ArrayList<>())));
        when(fieldRepository.existsById(1L)).thenReturn(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> fieldService.update(1L, updateDTO));
        assertEquals("Field area must be at least 0.1 hectare.", thrown.getMessage());
    }

    @Test
    void FarmAreaExceeded() {
        FieldCreateDTO createDTO = new FieldCreateDTO("Field1", 11.0, 1L);
        Farm farm = new Farm(1L, "Farm1", "Location1", 10.0, LocalDate.now(), new ArrayList<>());
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        when(fieldRepository.findByFarmId(1L)).thenReturn(new ArrayList<>());
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> fieldService.create(createDTO));
        assertEquals("The total area of fields in the farm cannot exceed the farm's total area.", thrown.getMessage());
    }


}

