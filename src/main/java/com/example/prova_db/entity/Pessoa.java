package com.example.prova_db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "emprego_id")
    private Emprego emprego;
}
