package org.sanaa.setnence.citronix.citronix.repository;

import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

    long countByFarmId(long farmId);

    @Query("SELECT SUM(f.area) FROM Field f WHERE f.farm_id = :farmId")
    Double sumAreaByFarmId(long farmId);


}
