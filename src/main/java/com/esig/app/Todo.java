package com.esig.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="todo")
public class Todo implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String titulo;
	private String descricao;
	private String responsavel;
	private boolean status;
	
	enum Prioridade {
		ALTA,
		MEDIA,
		BAIXA
	}
	
	private Prioridade prioridade;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public Prioridade getPrioridade() {
		return this.prioridade;
	}
	
	public void setPrioridade(Prioridade p) {
		this.prioridade = p;
	}
	
	public boolean isDone() {
		return status;
	}
	
	public void setDone(boolean status) {
		this.status = status;
	}
	
}
