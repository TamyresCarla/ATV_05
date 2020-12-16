package com.uepb.atividade.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.atividade.domain.Usuario;

/**
 * Interface UsuarioRepository no qual herda os metodos do JpaRepository.
 * 
 * @author Alice, Mickaely e Tamyres
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
