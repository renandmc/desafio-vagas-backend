package br.com.l4e.vagas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.l4e.vagas.model.Vaga;
import br.com.l4e.vagas.model.VagaRepository;

@Service
public class VagaService {

    @Autowired
    private VagaRepository repository;

    public List<Vaga> findAll() throws Exception {
        return repository.findAll();
    }

    public Optional<Vaga> findById(Integer id) throws Exception {
        return repository.findById(id);
    }

    public Vaga save(Vaga vaga) throws Exception {
        return repository.save(vaga);
    }

    public void delete(Integer id) throws Exception {
        repository.deleteById(id);
    }

}