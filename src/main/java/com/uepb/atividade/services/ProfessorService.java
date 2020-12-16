package com.uepb.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uepb.atividade.domain.Professor;
import com.uepb.atividade.repositories.ProfessorRepository;
import com.uepb.atividade.services.exception.DataIntegrityException;
import com.uepb.atividade.services.exception.ObjectNotFoundException;

/**
 * Camada service do professor com a lógica de negócio que faz a comunicacão com o
 * repository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;

	/**
	 * Faz a busca pelo professor através do ID passado como parâmetro.
	 * 
	 * @param id do professor
	 * @return os dados do professor se for encontrado, caso contrário retorna uma
	 *         mensagem informando o que aconteceu
	 */
	public Professor find(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}

	/**
	 * Insere os dados do professor através do objeto passado como parâmetro.
	 * 
	 * @param obj com os dados referentes ao professor
	 * @return o professor que foi inserido
	 */
	public Professor insert(Professor obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Atualiza os dados do professor passando um objeto como parâmetro.
	 * 
	 * @param obj com os dados a serem atualizados
	 * @return o professor com os dados atualizados
	 */
	public Professor update(Professor obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Deleta os dados do professor através do ID passado como parâmetro.
	 * 
	 * @param id do professor
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
	 * @return a lista dos professores cadastrados
	 */
	public List<Professor> findAll() {
		return repo.findAll();
	}

}
