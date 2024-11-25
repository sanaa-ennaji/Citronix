package org.sanaa.setnence.citronix.citronix.ServiceTest;


import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.FarmCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.FarmResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.FarmUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.exception.CustomException;
import org.sanaa.setnence.citronix.citronix.exception.EntityNotFoundException;
import org.sanaa.setnence.citronix.citronix.mapper.GenericMapper;
import org.sanaa.setnence.citronix.citronix.repository.FarmRepository;
import org.sanaa.setnence.citronix.citronix.service.impl.FarmService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FarmServiceTest {

    @Mock
    private GenericMapper<Farm, FarmCreateDTO, FarmUpdateDTO, FarmResponseDTO> mapper;

    @Mock
    private JpaRepository<Farm, Long> repository;

    @Mock
    private FarmRepository farmRepository;

    @InjectMocks
    private FarmService farmService;

    @BeforeEach
    public void setUp() {

        ReflectionTestUtils.setField(farmService, "farmRepository", farmRepository);
    }



    @Test
    public void InvalidArea() {
        FarmCreateDTO createDTO = new FarmCreateDTO("Farm A", "Location A", -1.0, LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> farmService.create(createDTO));
    }

    @Test
    public void EntityNotFoundException() {
        FarmCreateDTO createDTO = new FarmCreateDTO("Farm A", "Location A", 100.0, LocalDate.now());

        when(farmRepository.save(any(Farm.class))).thenThrow(EntityNotFoundException.class);
        assertThrows(CustomException.class, () -> farmService.create(createDTO));
    }




    @Test
    public void InvalidCreateDTO() {
        FarmCreateDTO createDTO = new FarmCreateDTO("", "", -1.0, null);
        assertThrows(ConstraintViolationException.class, () -> farmService.create(createDTO));
    }
}


