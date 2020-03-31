package br.com.l4e.vagas.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String cargo;

    private String descricao;

    private String locacao;

    private String tipo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataVencimento;

    private String situacao = "Aberta";

    @OneToMany(mappedBy = "vaga", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Colaborador> candidatos;

    public Vaga(String cargo, String descricao, String locacao, String tipo, LocalDate dataVencimento, String situacao) {
        this.cargo = cargo;
        this.descricao = descricao;
        this.locacao = locacao;
        this.tipo = tipo;
        this.dataVencimento = dataVencimento;
        this.situacao = situacao;
    }

}