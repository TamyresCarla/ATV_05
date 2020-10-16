package com.uepb.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uepb.atividade.domain.Turma;
import com.uepb.atividade.repositories.TurmaRepository;
import com.uepb.atividade.services.exception.DataIntegrityException;
import com.uepb.atividade.services.exception.ObjectNotFoundException;

/**
 * Camada service do cliente com a lógica de negócio que faz a comunicacão com o
 * repository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;

	/**
	 * Faz a busca pelo turma através do ID passado como parâmetro.
	 * 
	 * @param id da turma
	 * @return os dados da turma se for encontrado, caso contrário retorna uma
	 *         mensagem informando o que aconteceu
	 */
	public Turma find(Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}

	/**
	 * Insere os dados da turma através do objeto passado como parâmetro.
	 * 
	 * @param obj com os dados referentes a turma
	 * @return a turma que foi inserido
	 */
	public Turma insert(Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Atualiza os dados da turma passando um objeto como parâmetro.
	 * 
	 * @param obj com os dados a serem atualizados
	 * @return a turma com os dados atualizados
	 */
	public Turma update(Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Deleta os dados da turma através do ID passado como parâmetro.
	 * 
	 * @param id da turma
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
	 * @return a lista das turmas cadastrados
	 */
	public List<Turma> findAll() {
		return repo.findAll();
	}

}
