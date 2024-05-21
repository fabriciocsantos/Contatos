package br.com.fiap.contatos.dto;


import br.com.fiap.contatos.model.Usuario;

public record UsuarioExibicaoDto(Long id, String nome, String email) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail());
    }
}
