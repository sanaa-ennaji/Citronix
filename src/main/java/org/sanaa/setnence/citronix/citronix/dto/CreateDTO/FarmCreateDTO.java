package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmCreateDTO {
    @NotNull
    private String name;
    @NotBlank
    private String location;
    @NotNull
    private double area;
    @NotNull
    private String creationDate;

}
