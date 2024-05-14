package br.com.fiap.contatos.service;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato gravar(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato buscarId(Long id){

        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if(contatoOptional.isPresent()){
            return contatoOptional.get();
        }else{
            throw new RuntimeException("Contato não encontrado");
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
            throw new RuntimeException("Contato não encontrado");
        }
    }

//    public List<Contato> aniversarianteDoMes(LocalDate dataIni, LocalDate dataFim){
//        return contatoRepository.findByDataNascimentoBewtween(dataIni, dataFim);
//    }

    public Contato atualizar(Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(contato.getId());

        if(contatoOptional.isPresent()){
            return contatoRepository.save(contato);
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public Contato buscarPeloNome(String nome){
        Optional<Contato> contatoOptional = contatoRepository.findByNome(nome);
        if(contatoOptional.isPresent()){
            return contatoOptional.get();
        }else {
            throw new RuntimeException("Contato não encontrado");
        }
    }
}
