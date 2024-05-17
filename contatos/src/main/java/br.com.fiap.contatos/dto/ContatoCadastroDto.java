package br.com.fiap.contatos.dto;

import java.time.LocalDate;

public record ContatoCadastroDto( Long id, String nome, String email, LocalDate dataNascimento, String senha) {

}
