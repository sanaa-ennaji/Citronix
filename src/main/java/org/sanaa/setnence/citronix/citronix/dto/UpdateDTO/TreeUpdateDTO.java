package org.sanaa.setnence.citronix.citronix.dto.UpdateDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class TreeUpdateDTO {
    @NotNull(message = "The planting date is required.")
    @PastOrPresent(message = "The planting date must be in the past or today.")
    private LocalDate plantingDate;

    @NotNull(message = "Field ID is required.")
    private long fieldId;
}
