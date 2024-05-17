package br.com.fiap.contatos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TBL_CONTATOS")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    @SequenceGenerator(name = "SEQ_CONTATO", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Long id;

    @Column(name = "NM_CONTATO")
    private String nome;

    @Column(name = "EMAIL_CONTATO")
    private String email;

    @Column(name = "DTNASC_CONTATO")
    private LocalDate dataNascimento;

    @Column(name = "SENHA_CONTATO")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) && Objects.equals(nome, contato.nome) && Objects.equals(email, contato.email) && Objects.equals(dataNascimento, contato.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, dataNascimento);
    }

}
