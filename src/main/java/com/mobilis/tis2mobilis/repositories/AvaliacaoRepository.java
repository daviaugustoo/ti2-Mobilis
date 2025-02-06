package com.mobilis.tis2mobilis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobilis.tis2mobilis.models.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    Optional<Avaliacao> findByCpf(String cpf);
    void deleteByCpf(String cpf);
    List<Avaliacao> findByNomeContaining(String nome);
}
