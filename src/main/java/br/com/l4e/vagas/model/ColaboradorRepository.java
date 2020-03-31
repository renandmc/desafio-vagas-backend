package br.com.l4e.vagas.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.l4e.vagas.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {}