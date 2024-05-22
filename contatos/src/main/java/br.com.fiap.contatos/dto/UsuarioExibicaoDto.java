package br.com.fiap.contatos.dto;


import br.com.fiap.contatos.model.Usuario;
import br.com.fiap.contatos.model.UsuarioRole;

public record UsuarioExibicaoDto(Long id, String nome, String email, UsuarioRole role) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
