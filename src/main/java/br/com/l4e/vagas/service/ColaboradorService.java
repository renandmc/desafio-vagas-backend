package br.com.l4e.vagas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.l4e.vagas.model.Colaborador;
import br.com.l4e.vagas.model.ColaboradorRepository;
import br.com.l4e.vagas.model.Vaga;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private VagaService vagaService;

    public List<Colaborador> findAll() throws Exception {
        return repository.findAll();
    }

    public Optional<Colaborador> findById(Integer id) throws Exception {
        return repository.findById(id);
    }

    public Colaborador save(Colaborador colaborador) throws Exception {
        return repository.save(colaborador);
    }

    public Colaborador save(Colaborador colaborador, Integer idVaga) throws Exception {
        Vaga vaga = vagaService.findById(idVaga).get();
        colaborador.setVaga(vaga);
        return save(colaborador);
    }

}