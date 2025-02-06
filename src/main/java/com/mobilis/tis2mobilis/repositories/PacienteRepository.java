package com.mobilis.tis2mobilis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilis.tis2mobilis.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
        Optional<Paciente> findByCpf(String cpf);
}