package org.sanaa.setnence.citronix.citronix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private LocalDate plantingDate;

    private int age ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", nullable = false)
    private Field field ;

    @PrePersist
    @PostLoad
    public void calculateAge(){
        this.age = LocalDate.now().getYear() - this.plantingDate.getYear();
    }

}
