package com.uepb.atividade.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.atividade.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
