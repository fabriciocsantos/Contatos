package br.com.fiap.contatos.controller;

import br.com.fiap.contatos.dto.ContatoCadastroDto;
import br.com.fiap.contatos.dto.ContatoExibicaoDto;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoExibicaoDto gravar(@RequestBody @Valid ContatoCadastroDto contatoCadastroDto){
        return service.gravar(contatoCadastroDto);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarContatos(){
        return service.listarContatos();
    }

    @GetMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPorId(@PathVariable Long id){
        return service.buscarId(id);
    }
    @GetMapping("/contatos/consultaPorNome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(@RequestBody Contato contato){
        return service.atualizar(contato);
    }
}
