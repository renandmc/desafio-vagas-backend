package br.com.l4e.vagas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.l4e.vagas.model.entity.Colaborador;

public interface Colaboradores extends JpaRepository<Colaborador, Integer> {}