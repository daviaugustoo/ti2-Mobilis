package com.mobilis.tis2mobilis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilis.tis2mobilis.models.Duvida;

/**
 * Repositório para a entidade Duvida.
 * Este repositório fornece operações CRUD para a entidade Duvida.
 */
@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {
    List<Duvida> findByNome(String nome);  // Método para buscar por nome
}
