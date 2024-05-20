package br.com.fiap.contatos.service;

import br.com.fiap.contatos.dto.ContatoCadastroDto;
import br.com.fiap.contatos.dto.ContatoExibicaoDto;
import br.com.fiap.contatos.exception.ExceptionUserNotFound;
import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoExibicaoDto gravar(ContatoCadastroDto contatoCadastroDto){
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoCadastroDto, contato);
        return new ContatoExibicaoDto(contatoRepository.save(contato));
    }

    public ContatoExibicaoDto buscarId(Long id){

        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if(contatoOptional.isPresent()){
            return new ContatoExibicaoDto(contatoOptional.get());
        }else{
            throw new ExceptionUserNotFound("Contato não encontrado");
        }
    }

    public ContatoExibicaoDto buscarPorNome(String nome){

        Optional<Contato> contatoOptional = contatoRepository.buscarPorNome(nome);

        if(contatoOptional.isPresent()){
            return new ContatoExibicaoDto(contatoOptional.get());
        }else{
            throw new ExceptionUserNotFound("Contato não encontrado");
        }
    }

    public List<Contato> listarContatos(){
        return contatoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if(contatoOptional.isPresent()){
            contatoRepository.delete(contatoOptional.get());
        }else{
            throw new ExceptionUserNotFound("Contato não encontrado");
        }
    }

    public Contato atualizar(Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(contato.getId());

        if(contatoOptional.isPresent()){
            return contatoRepository.save(contato);
        }else{
            throw new ExceptionUserNotFound("Contato não encontrado");
        }
    }
}
