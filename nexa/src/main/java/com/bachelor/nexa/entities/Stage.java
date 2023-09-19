package com.bachelor.nexa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stages", schema = "dbo")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Journey journey;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private boolean status;
}
