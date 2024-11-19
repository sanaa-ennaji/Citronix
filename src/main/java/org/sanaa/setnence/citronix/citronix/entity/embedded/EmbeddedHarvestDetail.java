package org.sanaa.setnence.citronix.citronix.entity.embedded;

import jakarta.persistence.*;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;
import org.sanaa.setnence.citronix.citronix.entity.Tree;

import java.io.Serializable;

@Embeddable
public class EmbeddedHarvestDetail implements Serializable {

    @Column(name = "harvest_id")
    private Long harvestId;

    @Column(name = "tree_id")
    private Long treeId;


}
