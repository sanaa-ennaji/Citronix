package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
