package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO.HarvestDetailEmbbededDTO;
import org.sanaa.setnence.citronix.citronix.dto.EmbeddedDTO.SaleEmbeddedDTO;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestResponseDTO {
    private long id;

    private Season season;

    private LocalDate harvestDate;

    private double totalQuantity;

    private List<HarvestDetailEmbbededDTO> harvestDetails;

    private List<SaleEmbeddedDTO> sales;
}
