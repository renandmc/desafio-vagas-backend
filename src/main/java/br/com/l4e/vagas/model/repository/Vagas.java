package br.com.l4e.vagas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.l4e.vagas.model.entity.Vaga;

public interface Vagas extends JpaRepository<Vaga, Integer> {

    List<Vaga> findByCargoLike(String cargo);

    List<Vaga> findByCargoLikeOrDescricaoLikeOrderById(String cargo, String descricao);

    @Query("select v from Vaga v left join fetch v.colaboradores where v.id = :id")
    Vaga findVagaFetchColaboradores(@Param("id") Integer id);
}