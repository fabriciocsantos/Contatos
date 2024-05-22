package br.com.fiap.contatos.dto;

import br.com.fiap.contatos.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UsuarioCadastroDto(
        Long id,

        @NotBlank(message = "Nome do contato é obrigatório!")
        String nome,

        @NotBlank(message = "E-mail é obrigatório!")
        @Email(message = "E-mail está formatado incorretamente!")
        String email,

        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 5, max = 15, message = "Senha deve conter 5 ou 15 caracteres!")
        String senha,

        UsuarioRole role
) {
}
