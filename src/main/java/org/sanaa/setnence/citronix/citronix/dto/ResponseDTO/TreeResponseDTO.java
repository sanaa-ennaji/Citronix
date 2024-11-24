package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeResponseDTO {

    private long id;

    private LocalDate plantingDate;

    private int age;

    private Long fieldId;
}
