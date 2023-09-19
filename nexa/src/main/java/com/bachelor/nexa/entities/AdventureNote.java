package com.bachelor.nexa.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Adventure_Notes", schema = "dbo")
public class AdventureNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "title")
    private String title;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "accomplishment")
    private String accomplishment;
    @Column(name = "improvement")
    private String improvement;
    @Column(name = "thought")
    private String thought;
}
