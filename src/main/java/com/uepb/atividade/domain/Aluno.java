package com.uepb.atividade.domain;

import javax.persistence.Entity;

import com.uepb.atividade.enums.PapelAluno;

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
public class Aluno extends Usuario {

	private static final long serialVersionUID = 1L;

	private String curso;
	private Integer papelAluno; 

	
	public Aluno() {
	}


	/**
	 * Construtor passando como parâmetro o ID, nome e curso do aluno
	 * 
	 * @param id    do aluno
	 * @param nome  do aluno
	 * @param curso do aluno
	 */
	public Aluno(Integer id, String nome, String curso, PapelAluno papelAluno) {
		super(id, nome);
		this.curso = curso;
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


	public PapelAluno getPapelAluno() {
		return PapelAluno.toEnum(papelAluno);
	}


	public void setPapelAluno(PapelAluno papelAluno) {
		this.papelAluno = papelAluno.getCod();
	}


}
