package com.uepb.atividade.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * Representa a turma contendo o ID, nome e o turno
 * 
 * @author Alice, Mickaely, Tamyres
 *
 */
@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String turno;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="Aluno")
	private Turma turma;
	
	/**
	 * Construtor passando como parâmetro o ID, nome e turno da turma
	 * 
	 * @param id da turma
	 * @param nome da turma
	 * @param curso da turma
	 */
	public Turma(Integer id, String nome, String turno) {
		super();
		this.id = id;
		this.nome = nome;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
}
