package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.embedded.EmbeddedHarvestDetail;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HarvestDetail {
    @EmbeddedId
    private EmbeddedHarvestDetail id;

    @MapsId("harvestId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "harvest_id", nullable = false, insertable = false, updatable = false)
    private Harvest harvest;

    @MapsId("treeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tree_id", nullable = false, insertable = false, updatable = false)
    private Tree tree;

    @NotNull
    private double quantity;
}
