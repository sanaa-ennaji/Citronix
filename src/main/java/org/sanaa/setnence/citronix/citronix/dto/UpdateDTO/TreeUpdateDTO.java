package org.sanaa.setnence.citronix.citronix.dto.UpdateDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeUpdateDTO {
    @NotNull(message = "The planting date is required.")
    @PastOrPresent(message = "The planting date must be in the past or today.")
    private LocalDate plantingDate;

    @NotNull(message = "Field ID is required.")
    private long fieldId;
}
