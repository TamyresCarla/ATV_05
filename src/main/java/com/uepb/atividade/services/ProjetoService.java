package com.uepb.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uepb.atividade.domain.Projeto;
import com.uepb.atividade.repositories.ProjetoRepository;
import com.uepb.atividade.services.exception.DataIntegrityException;
import com.uepb.atividade.services.exception.ObjectNotFoundException;

/**
 * Camada service do projeto com a lógica de negócio que faz a comunicacão com o
 * repository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repo;

	/**
	 * Faz a busca pelo projeto através do ID passado como parâmetro.
	 * 
	 * @param id do projeto
	 * @return os dados do projeto se for encontrado, caso contrário retorna uma
	 *         mensagem informando o que aconteceu
	 */
	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Projeto.class.getName()));
	}

	/**
	 * Insere os dados do projeto através do objeto passado como parâmetro.
	 * 
	 * @param obj com os dados referentes ao projeto
	 * @return o projeto que foi inserido
	 */
	public Projeto insert(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Atualiza os dados do projeto passando um objeto como parâmetro.
	 * 
	 * @param obj com os dados a serem atualizados
	 * @return o projeto com os dados atualizados
	 */
	public Projeto update(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Deleta os dados do projeto através do ID passado como parâmetro.
	 * 
	 * @param id do projeto
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
	 * @return a lista dos projetoscadastrados
	 */
	public List<Projeto> findAll() {
		return repo.findAll();
	}

}
