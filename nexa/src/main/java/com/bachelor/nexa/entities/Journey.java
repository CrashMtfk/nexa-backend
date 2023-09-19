package com.bachelor.nexa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Objectives", schema = "dbo")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "journey")
    private List<Stage> stageSet;
    @Column(name = "title")
    private String title;
    @Column(name = "coins")
    private int coins;
    @Column(name = "experience")
    private int experience;
}
