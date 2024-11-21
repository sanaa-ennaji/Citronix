package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO.FieldEmbbededDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmResponseDTO {

    private long id ;
    private String name;
    private String location;
    private double area;
    private LocalDate createDate;
    private List<FieldEmbbededDTO> fields ;
}
