package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;
import org.sanaa.setnence.citronix.citronix.entity.Tree;
import org.sanaa.setnence.citronix.citronix.validation.annotation.Exists;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailCreateDTO {
    @Exists(entity = Harvest.class, message = "harvest not found.")
    private Long harvestId;

    @Exists(entity = Tree.class, message = "tree not found.")
    private Long treeId;

    @NotNull(message = "Quantity must not be null.")
    private double quantity;

}
