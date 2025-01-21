package com.lucas.think_fool.post;

import java.time.LocalDateTime;

import com.lucas.think_fool.thinker.Thinker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "thinker_id", nullable = false)
    private Thinker thinker;
}
