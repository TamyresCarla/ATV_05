package com.uepb.atividade.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uepb.atividade.domain.Aluno;
import com.uepb.atividade.services.AlunoService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {

	@Autowired
	private AlunoService service;

	/**
	 * Metodo find criado para efetuar a operação de GET passando um id, ou seja,
	 * ele busca uma turma pelo id.
	 * 
	 * 
	 * @param id
	 * @return turma
	 * 
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Aluno obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Metodo insert criado para efetuar inserções usando a operação de POST
	 * passando um objeto do tipo turma.
	 * 
	 * @param obj
	 * 
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Metodo update criado para efetuar atualizacoes usando a operação de PUT
	 * passando um objeto do tipo aluno e o id da turma.
	 * 
	 * @param obj, id
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Metodo delete criado para efetuar exclusoes usando a operação de DELETE
	 * passando o id da turma.
	 * 
	 * @param id
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
