package com.generation.gameshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryData(
        @Column(unique = true)
        @NotBlank(message = "O campo 'name' é obrigatório.")
        @Size(min = 2, max = 100, message = "O campo 'name' deve conter de 2 a 100 caracteres.")
        String name) {}
