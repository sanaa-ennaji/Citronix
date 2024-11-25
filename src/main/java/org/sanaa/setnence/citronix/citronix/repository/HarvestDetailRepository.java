package org.sanaa.setnence.citronix.citronix.repository;

import org.sanaa.setnence.citronix.citronix.entity.HarvestDetail;
import org.sanaa.setnence.citronix.citronix.entity.embedded.EmbeddedHarvestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestDetailRepository extends JpaRepository<HarvestDetail, EmbeddedHarvestDetail> {
}


