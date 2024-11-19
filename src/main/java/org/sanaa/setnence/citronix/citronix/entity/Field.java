package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false, unique = true )
    private String name;

    @Column(nullable = false)
    private double area ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
    @OneToMany(mappedBy = "field", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Tree> trees;

}
