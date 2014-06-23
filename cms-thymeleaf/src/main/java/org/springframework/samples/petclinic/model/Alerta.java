package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alerta")
public class Alerta extends BaseEntity {

	@NotEmpty(message = "O campo Título é de preenchimento obrigatório.")
	@Size(min = 5, message = "O campo Título deve conter pelo menos {min} caracteres.")
	private String titulo;

	@NotEmpty(message = "O campo Conteúdo é de preenchimento obrigatório.")
	@Size(min = 10, message = "O campo Conteúdo deve conter pelo menos {min} caracteres.")
	private String conteudo;

	@NotNull(message = "O campo Data Início é de preenchimento obrigatório.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@NotNull(message = "O Data Fim é de preenchimento obrigatório.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}