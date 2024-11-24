package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestCreateDTO {

    @NotNull(message = "Season must not be null.")
    private Season season;

    @NotNull(message = "Harvest date must not be null.")
    private LocalDate harvestDate;

    @Min(value = 0, message = "Total quantity must be greater than or equal to 0.")
    private double totalQuantity;

    private List<HarvestDetailCreateDTO> details;



}
