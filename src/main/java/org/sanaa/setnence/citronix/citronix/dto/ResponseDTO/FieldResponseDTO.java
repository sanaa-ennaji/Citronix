package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO.TreeEmbeddedDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponseDTO {

    private long id ;
    private String name;
    private double area ;
    private long farmId;
    private List<TreeEmbeddedDTO> trees ;
}
