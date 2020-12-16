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

import com.uepb.atividade.domain.Projeto;
import com.uepb.atividade.services.ProjetoService;

/**
 * Camada Controller do projeto que faz a comunicação com a aplicação cliente para
 * que as requisições possam ser atendidas.
 * 
 *
 * @author Alice, Mickaely e Tamyres
 *
 */
@RestController
@RequestMapping(value = "/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService service;

	/**
	 * Metodo find criado para efetuar a operação de GET passando um id, ou seja,
	 * ele busca um projeto pelo id.
	 * 
	 * 
	 * @param id
	 * @return projeto
	 * 
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Projeto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Metodo insert criado para efetuar inserções usando a operação de POST
	 * passando um objeto do tipo projeto.
	 * 
	 * @param obj
	 * 
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Projeto obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Metodo update criado para efetuar atualizacoes usando a operação de PUT
	 * passando um objeto do tipo projeto e o id do projeto.
	 * 
	 * @param obj, id
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Projeto obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Metodo delete criado para efetuar exclusoes usando a operação de DELETE
	 * passando o id do projeto.
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
