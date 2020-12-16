package com.uepb.atividade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uepb.atividade.domain.Usuario;
import com.uepb.atividade.repositories.UsuarioRepository;
import com.uepb.atividade.services.exception.DataIntegrityException;
import com.uepb.atividade.services.exception.ObjectNotFoundException;

/**
 * Camada service do usuario com a lógica de negócio que faz a comunicacão com o
 * repository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	/**
	 * Faz a busca pelo usuario através do ID passado como parâmetro.
	 * 
	 * @param id do usuario
	 * @return os dados do usuario se for encontrado, caso contrário retorna uma
	 *         mensagem informando o que aconteceu
	 */
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	/**
	 * Insere os dados do usuario através do objeto passado como parâmetro.
	 * 
	 * @param obj com os dados referentes ao usuario
	 * @return o usuario que foi inserido
	 */
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Atualiza os dados do usuario passando um objeto como parâmetro.
	 * 
	 * @param obj com os dados a serem atualizados
	 * @return o usuario com os dados atualizados
	 */
	public Usuario update(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/**
	 * Deleta os dados do usuario através do ID passado como parâmetro.
	 * 
	 * @param id do usuario
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
	 * @return a lista dos usuarios cadastrados
	 */
	public List<Usuario> findAll() {
		return repo.findAll();
	}

}
