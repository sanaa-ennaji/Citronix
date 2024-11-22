package org.sanaa.setnence.citronix.citronix.dto.UpdateDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailUpdateDTO {
    private long harvestId;

    private long treeId;

    @NotNull(message = "Quantity must not be null.")
    private double quantity ;

}
