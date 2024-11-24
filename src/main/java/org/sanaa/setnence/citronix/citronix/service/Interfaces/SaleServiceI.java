package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.SaleCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.SaleResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.SaleUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Sale;

public interface SaleServiceI extends GenericServiceI<Sale, SaleCreateDTO, SaleUpdateDTO, SaleResponseDTO>{
}
