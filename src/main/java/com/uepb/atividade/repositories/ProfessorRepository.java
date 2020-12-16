package com.uepb.atividade.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.atividade.domain.Professor;

/**
 * Interface ProfessorRepository no qual herda os metodos do JpaRepository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
