package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.validation.annotation.Exists;



public class FieldCreateDTO {

    private String name;

    private double area ;

    @Exists(entity = Farm.class, message = "farm not found.")
    private long farmId;

}
