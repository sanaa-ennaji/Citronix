package org.sanaa.setnence.citronix.citronix.entity.embedded;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class EmbeddedHarvestDetail implements Serializable {

    private Long harvestId;

    private Long treeId;


}
