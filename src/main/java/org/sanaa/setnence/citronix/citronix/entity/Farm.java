package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    private String name ;

    @NotNull
    private String location;

    @Column(nullable = false)
    private double area ;

    @NotNull
    private LocalDate createDate ;

    @OneToMany(mappedBy = "farm" , cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Field> fields ;



}
