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
    @NotNull
    private String name;
    @NotBlank
    private String location;
    @NotNull
    private double area;
    @NotNull
    private LocalDate creationDate;
    private List<FieldEmbbededDTO> fields ;
}
