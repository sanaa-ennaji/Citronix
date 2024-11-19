package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Season season;

    @NotNull
    private LocalDate harvestDate;

    @Column(nullable = false)
    private double totalQuantity ;

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HarvestDetail> harvestDetails;




}
