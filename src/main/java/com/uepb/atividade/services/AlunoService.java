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


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	public Aluno find(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
		}

	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Aluno update(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Aluno> findAll() {
		return repo.findAll();
	}
	

}
