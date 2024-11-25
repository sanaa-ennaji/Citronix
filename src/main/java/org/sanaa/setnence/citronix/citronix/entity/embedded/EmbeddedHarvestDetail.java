package org.sanaa.setnence.citronix.citronix.entity.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmbeddedHarvestDetail implements Serializable {

    @Column(name = "harvest_id")
    private Long harvestId;

    @Column(name = "tree_id")
    private Long treeId;


}
