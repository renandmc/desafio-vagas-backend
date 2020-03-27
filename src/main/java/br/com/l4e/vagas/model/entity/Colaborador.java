package br.com.l4e.vagas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    
    private String cpf;
    
    @Column(name = "cargo_atual")
    private String cargoAtual;
    
    @Column(name = "area_atual")
    private String areaAtual;
    
    private String email;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    public Colaborador(String nome, String cpf, String cargoAtual, String areaAtual, String email, Vaga vaga) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargoAtual = cargoAtual;
        this.areaAtual = areaAtual;
        this.email = email;
        this.vaga = vaga;
    }

}