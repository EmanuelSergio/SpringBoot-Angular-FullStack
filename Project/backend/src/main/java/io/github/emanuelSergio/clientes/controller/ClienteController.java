package io.github.emanuelSergio.clientes.controller;

import io.github.emanuelSergio.clientes.model.entity.Cliente;
import io.github.emanuelSergio.clientes.model.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//RETORNA O CODIGO DE STATUS EX:200, 404
    public Cliente salvar(@RequestBody @Valid Cliente cliente){ //para realmente salvar é necessario essas duas anotatios
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){


        //aqui vai achar o usuario pelo Id ou vai lançar a exceção, por isso a função lambda chamando o status
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //retornando o status http sem conteudo (porque foi deletado)
    public void deletar(@PathVariable Integer id){

        repository.findById(id).map( cliente -> { //repositorio procura por id e cria um map para deletar
            repository.delete(cliente);           //como tem uma callback, deve retornar algo
            return Void.TYPE;                     //nesse caso retorno tipo vazio
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")); //se não achar. lanço o HTTP STATUS

        repository.deleteById(id);

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id ,@RequestBody @Valid Cliente clienteAtualizado){
        repository
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    return repository.save(clienteAtualizado);
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
