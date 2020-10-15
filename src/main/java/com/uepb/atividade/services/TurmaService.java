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

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;

	public Turma find(Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}

	public Turma insert(Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Turma update(Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Turma> findAll() {
		return repo.findAll();
	}

}
