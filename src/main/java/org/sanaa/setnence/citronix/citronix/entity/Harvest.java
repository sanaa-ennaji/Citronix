package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sanaa.setnence.citronix.citronix.entity.enums.Season;

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


}
