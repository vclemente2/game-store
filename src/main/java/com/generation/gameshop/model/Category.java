package com.generation.gameshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "O campo 'name' é obrigatório.")
    @Size(min=2 , max=100, message = "O campo 'name' deve conter de 2 a 100 caracteres.")
    private String name;
}
