package com.bachelor.nexa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Quests", schema = "dbo")
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "difficulty_id", referencedColumnName = "id")
    private Difficulty difficulty;
    @Column(name = "title")
    private String title;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "status")
    private boolean status;
}
