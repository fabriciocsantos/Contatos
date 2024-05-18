package br.com.fiap.contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContatoCadastroDto(

        Long id,

        @NotBlank(message = "Nome do contato é obrigatório!")
        String nome,

        @NotBlank(message = "E-mail é obrigatório!")
        @Email(message = "E-mail está formatado incorretamente!")
        String email,

        @NotNull(message = "Data de nascimento obrigatória")
        LocalDate dataNascimento,

        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 5, max = 15, message = "Senha deve conter 5 ou 15 caracteres!")
        String senha
) {

}
