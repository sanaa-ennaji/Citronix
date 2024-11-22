package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDTO {

    private long id;

    private LocalDate saleDate;

    private double unitPrice;

    private double quantity;

    private double revenue;

    private long harvestId;
}
