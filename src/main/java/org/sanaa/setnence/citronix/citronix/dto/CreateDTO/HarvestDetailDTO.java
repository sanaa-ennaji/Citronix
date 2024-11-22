package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.NotNull;

public class HarvestDetailDTO {

    private long harvestId;

    private long treeId;

    @NotNull(message = "Quantity must not be null.")
    private double quantity ;

}
