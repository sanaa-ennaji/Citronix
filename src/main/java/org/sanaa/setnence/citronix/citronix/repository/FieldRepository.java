package org.sanaa.setnence.citronix.citronix.repository;

import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

    long countByFarmId(long farmId);

    @Query(value = "SELECT COUNT(f.id) as count, SUM(f.area) as sumArea FROM field f WHERE f.farm_id = :farmId", nativeQuery = true)
    FieldStatDTO getFieldStatsByFarmId(@Param("farmId") long farmId);


}
