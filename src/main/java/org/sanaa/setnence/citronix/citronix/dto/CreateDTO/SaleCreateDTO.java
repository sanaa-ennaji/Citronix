package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;
import org.sanaa.setnence.citronix.citronix.validation.annotation.Exists;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleCreateDTO {
    @NotNull(message = "Sale date cannot be null.")
    private LocalDate saleDate;

    @NotNull(message = "Unit price must not be null.")
    @Min(value = 0, message = "Unit price must be greater than or equal to 0.")
    private double unitPrice;

    @NotNull(message = "Quantity must not be null.")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0.")
    private double quantity;

    @NotNull(message = "Harvest ID cannot be null.")
    @Exists(entity = Harvest.class, message = "harvest not found.")
    private long harvestId;
}
