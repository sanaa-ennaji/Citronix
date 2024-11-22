package org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleEmbeddedDTO {
    private long id;
    private double unitPrice;
    private double quantity ;
}
