package org.sanaa.setnence.citronix.citronix.repository;

import org.sanaa.setnence.citronix.citronix.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByFarmId(Long farmId);



}
