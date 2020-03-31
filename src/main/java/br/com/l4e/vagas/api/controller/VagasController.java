package br.com.l4e.vagas.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.l4e.vagas.model.Vaga;
import br.com.l4e.vagas.service.VagaService;

@RestController
@RequestMapping("/api/vagas")
public class VagasController {

    @Autowired
    private VagaService service;

    @GetMapping
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id).get());
        } catch(Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Vaga vaga) {
        try {
            return ResponseEntity.ok(service.save(vaga));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody Vaga vaga) {
        try {
            return ResponseEntity.ok(service.save(vaga));
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}