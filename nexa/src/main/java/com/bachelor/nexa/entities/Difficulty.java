package com.bachelor.nexa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Difficulties", schema = "dbo")
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "grade")
    private char grade;
    @Column(name = "coins")
    private int coins;
    @Column(name = "experience")
    private int experience;
}
