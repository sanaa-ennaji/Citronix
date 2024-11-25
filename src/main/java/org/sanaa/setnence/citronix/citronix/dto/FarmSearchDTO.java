package org.sanaa.setnence.citronix.citronix.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmSearchDTO {
    private String name;
    private String location;
    private LocalDate startDate;
}