package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailResponseDTO {
    private long harvestId;

    private long treeId;

    private double quantity;
}
