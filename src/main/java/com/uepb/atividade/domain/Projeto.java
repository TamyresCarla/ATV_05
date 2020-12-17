package com.uepb.atividade.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Representa o projeto contendo o ID, nome e o descricao
 * 
 * @author Alice, Mickaely, Tamyres
 *
 */
@Entity
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;

	@OneToOne
	@JoinColumn(name="professor_id")
	@MapsId
	private Professor professor;
	
	@ManyToMany(mappedBy="projetos")
	private List<Usuario> usuarios = new ArrayList<>();
	/**
	 * Construtor passando como parâmetro o ID, nome e descricao do projeto
	 * 
	 * @param id    do projeto
	 * @param nome  do projeto
	 * @param descricao do projeto
	 */
	public Projeto(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * @return o ID do projeto
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o ID do projeto
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return o nome do projeto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o nome do projeto
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o descricao do projeto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Seta o descricao do projeto
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
