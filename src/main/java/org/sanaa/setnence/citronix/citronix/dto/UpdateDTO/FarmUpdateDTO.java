package org.sanaa.setnence.citronix.citronix.dto.UpdateDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmUpdateDTO {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Location cannot be blank")
    private String location;

    @NotNull(message = "Area cannot be null")
    @Min(value = 1, message = "Area must be greater than 0")
    private double area;

    @NotNull(message = "Creation date cannot be null")
    private LocalDate creationDate;
}
