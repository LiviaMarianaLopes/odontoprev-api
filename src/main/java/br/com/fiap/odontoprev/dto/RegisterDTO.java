package br.com.fiap.odontoprev.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @Email(message = "O email deve ser válido")
        @NotBlank(message = "O email não pode estar vazio")
        String email,

        @NotBlank(message = "A senha não pode estar vazia")
        String senha) {}
