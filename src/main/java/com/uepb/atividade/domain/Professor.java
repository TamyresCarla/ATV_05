package com.uepb.atividade.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Representa o professor contendo a area de atuacao, formacao, id e nome
 * 
 * @author Alice, Mickaely, Tamyres
 *
 */
@Entity
public class Professor extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String matricula;
	private String areaAtuacao;
	private String formacao;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="professor")
	private Projeto projeto;

	/**
	 * Construtor passando como parâmetro o ID, nome, area de atuacai e formacao do professor
	 * 
	 * @param id    do professor
	 * @param nome  do professor
	 * @param curso do professor
	 */
	public Professor(long id, String name,String matricula, String areaAtuacao, String formacao) {
		super();
		this.areaAtuacao = areaAtuacao;
		this.formacao = formacao;
		this.matricula = matricula;
	}

	/**
	 * @return a area de atuacao do professor
	 */
	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	/**
	 * Seta a area de atuacao
	 * 
	 * @param areaAtuacao
	 */
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}


	/**
	 * @return a formacao do professor
	 */
	public String getFormacao() {
		return formacao;
	}

	/**
	 * Seta a formacao do professor
	 * 
	 * @param id
	 */
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	/**
	 * @return a matricula do professor
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Seta a matricula do professor
	 * 
	 * @param id
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



}
