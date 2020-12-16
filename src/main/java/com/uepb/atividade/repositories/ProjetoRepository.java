package com.uepb.atividade.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.atividade.domain.Projeto;

/**
 * Interface ProjetoRepository no qual herda os metodos do JpaRepository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

}
