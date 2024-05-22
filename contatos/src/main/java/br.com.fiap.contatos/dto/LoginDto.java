package br.com.fiap.contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "Email do usuário é obrigatório!")
        @Email(message = "Formato de Email incorreto!")
        String email,

        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 5, max = 15, message = "Senha deve conter 5 ou 15 caracteres!")
        String senha
) {
}
