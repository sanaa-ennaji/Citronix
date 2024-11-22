package org.sanaa.setnence.citronix.citronix.dto.ResponseDTO;

import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

import java.time.LocalDate;

public class HarvestResponseDTO {
    private long id;

    private Season season;

    private LocalDate harvestDate;

    private double totalQuantity;

    private List<HarvestDetailResponseDTO> harvestDetails;

    private List<SaleResponseDTO> sales;
}
