package br.com.fiap.contatos.repository;

import br.com.fiap.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public Contato findByNome(String nome);
    public List<Contato> findByDataNascimentoBewtween(LocalDate dataInicial, LocalDate dataFinal);

}
