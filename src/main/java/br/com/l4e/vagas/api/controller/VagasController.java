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

import br.com.l4e.vagas.model.entity.Vaga;
import br.com.l4e.vagas.model.repository.Vagas;

@RestController
@RequestMapping("/api/vagas")
public class VagasController {

    private Vagas vagas;

    public VagasController(Vagas vagas) {
        this.vagas = vagas;
    }

    @GetMapping("/{id}")
    public Vaga one(@PathVariable Integer id) {
        return vagas
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga save(@RequestBody Vaga vaga) {
        return vagas.save(vaga);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        vagas.findById(id)
            .map(colab -> {
                vagas.delete(colab);
                return colab;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Vaga vaga) {
        vagas
            .findById(id)
            .map(colab -> {
                vaga.setId(colab.getId());
                vagas.save(vaga);
                return colab;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Vaga> find(Vaga filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Vaga> example = Example.of(filtro, matcher);
        return vagas.findAll(example);
    }
}