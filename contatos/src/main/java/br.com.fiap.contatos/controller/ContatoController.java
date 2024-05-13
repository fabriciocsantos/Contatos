package br.com.fiap.contatos.controller;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato gravar(@RequestBody Contato contato){
        return service.gravar(contato);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarContatos(){
        return service.listarContatos();
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(Contato contato){
        return service.atualizar(contato);
    }

    @GetMapping("/contatos/{nome}")
    public Contato buscarNome(@PathVariable String nome){
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/contatos/{dataIni}/{dataFim}")
    public List<Contato> aniversarianteMes(@PathVariable LocalDate dataIni,@PathVariable LocalDate dataFim){
        return service.aniversarianteDoMes(dataIni, dataFim);
    }
}
