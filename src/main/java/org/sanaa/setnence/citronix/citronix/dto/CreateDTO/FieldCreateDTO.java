package org.sanaa.setnence.citronix.citronix.dto.CreateDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.Farm;
import org.sanaa.setnence.citronix.citronix.validation.annotation.Exists;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldCreateDTO {

    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @NotNull(message = "Area must not be null.")
    @Min(value = 0, message = "Area must be greater than or equal to 0.")
    private double area ;

    @Exists(entity = Farm.class, message = "farm not found.")
    private long farmId;

}
