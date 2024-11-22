package org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailEmbbededDTO {
    private long treeId;
    private double quantity;
}
