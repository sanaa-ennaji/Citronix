package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

import java.time.LocalDate;

public class HarvestCreateDTO {

    @NotNull(message = "Season must not be null.")
    private Season season;

    @NotNull(message = "Harvest date must not be null.")
    private LocalDate harvestDate;

    @NotNull(message = "Total quantity must not be null.")
    @Min(value = 0, message = "Total quantity must be greater than or equal to 0.")
    private double totalQuantity;

}
