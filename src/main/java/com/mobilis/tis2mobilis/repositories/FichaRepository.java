package com.mobilis.tis2mobilis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilis.tis2mobilis.models.Ficha;

/**
 * Repositório para a entidade Ficha.
 * Este repositório fornece operações CRUD para a entidade Ficha.
 */
@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    Optional<Ficha> findByCpf(String cpf);
    void deleteByCpf(String cpf);
}
