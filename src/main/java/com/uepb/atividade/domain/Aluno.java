package com.uepb.atividade.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Representa o aluno contendo o ID, nome e o curso
 * 
 * @author Alice, Mickaely, Tamyres
 *
 */
/**
 * @author Alice, Mickaely, Tamyres
 *
 */

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String curso;

	@OneToOne
	private Turma turma;

	/**
	 * Construtor passando como parâmetro o ID, nome e curso do aluno
	 * 
	 * @param id    do aluno
	 * @param nome  do aluno
	 * @param curso do aluno
	 */
	public Aluno(Integer id, String nome, String curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * @return o ID do aluno
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o ID do aluno
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return o nome do aluno
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o nome do aluno
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o curso do aluno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Seta o curso do aluno
	 * 
	 * @param curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
