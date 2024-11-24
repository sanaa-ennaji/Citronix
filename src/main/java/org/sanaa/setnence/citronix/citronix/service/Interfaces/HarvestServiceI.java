package org.sanaa.setnence.citronix.citronix.service.Interfaces;

import org.sanaa.setnence.citronix.citronix.dto.CreateDTO.HarvestCreateDTO;
import org.sanaa.setnence.citronix.citronix.dto.ResponseDTO.HarvestResponseDTO;
import org.sanaa.setnence.citronix.citronix.dto.UpdateDTO.HarvestUpdateDTO;
import org.sanaa.setnence.citronix.citronix.entity.Harvest;

public interface HarvestServiceI  extends GenericServiceI<Harvest, HarvestCreateDTO, HarvestUpdateDTO, HarvestResponseDTO>{
}
