package org.springframework.samples.petclinic.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "alerta")
public class Comunidade extends BaseEntity {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;
    private String sexo;
    private Integer idadeMinima;
    private Integer idadeMaxima;
    private Long rendaMinima;
    private Long rendaMaxima;
    private String segmento;

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(Integer idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public Integer getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(Integer idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public Long getRendaMinima() {
        return rendaMinima;
    }

    public void setRendaMinima(Long rendaMinima) {
        this.rendaMinima = rendaMinima;
    }

    public Long getRendaMaxima() {
        return rendaMaxima;
    }

    public void setRendaMaxima(Long rendaMaxima) {
        this.rendaMaxima = rendaMaxima;
    }
}
