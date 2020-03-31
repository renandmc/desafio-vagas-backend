package br.com.l4e.vagas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    private String cargoAtual;
    
    private String areaAtual;
    
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga_id")
    @JsonIgnore
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