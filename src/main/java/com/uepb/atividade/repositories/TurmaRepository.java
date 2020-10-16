package com.uepb.atividade.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.atividade.domain.Turma;

/**
 * Interface TurmaRepository no qual herda os metodos do JpaRepository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
