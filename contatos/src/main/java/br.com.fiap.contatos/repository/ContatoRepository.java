package br.com.fiap.contatos.repository;

import br.com.fiap.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
