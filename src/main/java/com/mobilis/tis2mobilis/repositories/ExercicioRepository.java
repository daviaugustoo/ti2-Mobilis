package com.mobilis.tis2mobilis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilis.tis2mobilis.models.Exercicio;

/**
 * Repositório para a entidade Exercicio.
 * Este repositório fornece operações CRUD para a entidade Exercicio.
 */
@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    List<Exercicio> findByCpf(String cpf);
    void deleteByCpf(String cpf);
}
