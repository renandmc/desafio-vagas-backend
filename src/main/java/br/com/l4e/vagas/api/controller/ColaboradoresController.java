package br.com.l4e.vagas.api.controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.l4e.vagas.model.entity.Colaborador;
import br.com.l4e.vagas.model.repository.Colaboradores;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradoresController {

    private final Colaboradores colaboradores;

    public ColaboradoresController(Colaboradores colaboradores) {
        this.colaboradores = colaboradores;
    }

    @GetMapping("/{id}")
    public Colaborador one(@PathVariable Integer id) {
        return colaboradores
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Colaborador save(@RequestBody Colaborador colaborador) {
        return colaboradores.save(colaborador);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        colaboradores.findById(id)
            .map(colab -> {
                colaboradores.delete(colab);
                return colab;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
        colaboradores
            .findById(id)
            .map(colab -> {
                colaborador.setId(colab.getId());
                colaboradores.save(colaborador);
                return colab;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Colaborador> find(Colaborador filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Colaborador> example = Example.of(filtro, matcher);
        return colaboradores.findAll(example);
    }

}