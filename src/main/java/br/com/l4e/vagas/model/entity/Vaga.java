package br.com.l4e.vagas.model.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    private String situacao;

    @OneToMany(mappedBy = "vaga")
    private Set<Colaborador> colaboradores;

    public Vaga(String cargo, String descricao, String locacao, String tipo, LocalDate dataVencimento, String situacao) {
        this.cargo = cargo;
        this.descricao = descricao;
        this.locacao = locacao;
        this.tipo = tipo;
        this.dataVencimento = dataVencimento;
        this.situacao = situacao;
    }

}