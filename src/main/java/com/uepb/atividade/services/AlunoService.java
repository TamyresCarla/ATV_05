package com.uepb.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uepb.atividade.domain.Aluno;
import com.uepb.atividade.repositories.AlunoRepository;
import com.uepb.atividade.services.exception.DataIntegrityException;
import com.uepb.atividade.services.exception.ObjectNotFoundException;

/**
 * Camada service do aluno com a lógica de negócio que faz a comunicacão com o
 * repository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;

	/**
	 * Faz a busca pelo aluno através do ID passado como parâmetro.
	 * 
	 * @param id do aluno
	 * @return os dados do aluno se for encontrado, caso contrário retorna uma
	 *         mensagem informando o que aconteceu
	 */
	public Aluno find(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

	/**
	 * Insere os dados do aluno através do objeto passado como parâmetro.
	 * 
	 * @param obj com os dados referentes ao aluno
	 * @return o aluno que foi inserido
	 */
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Atualiza os dados do aluno passando um objeto como parâmetro.
	 * 
	 * @param obj com os dados a serem atualizados
	 * @return o aluno com os dados atualizados
	 */
	public Aluno update(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Deleta os dados do aluno através do ID passado como parâmetro.
	 * 
	 * @param id do aluno
	 */
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	/**
	 * @return a lista dos alunos cadastrados
	 */
	public List<Aluno> findAll() {
		return repo.findAll();
	}

}
