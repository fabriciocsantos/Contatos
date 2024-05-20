package br.com.fiap.contatos.repository;

import br.com.fiap.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE c.nome = :nome")
    Optional<Contato> buscarPorNome(@Param("nome") String nomeAtribuido);
}
