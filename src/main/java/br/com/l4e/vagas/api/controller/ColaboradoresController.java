package br.com.l4e.vagas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.l4e.vagas.model.Colaborador;
import br.com.l4e.vagas.service.ColaboradorService;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradoresController {

    @Autowired
    private ColaboradorService service;

    @GetMapping
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/candidatar/{vaga}")
    public ResponseEntity<?> post(@PathVariable Integer vaga, @RequestBody Colaborador colaborador) {
        try {
            return ResponseEntity.ok(service.save(colaborador, vaga));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}