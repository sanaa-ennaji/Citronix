package org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldEmbbededDTO {
    private long id ;
    private String name;
}
