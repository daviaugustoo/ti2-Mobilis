package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobilis.tis2mobilis.models.Paciente;
import com.mobilis.tis2mobilis.repositories.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    /*public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }*/
    public Optional<Paciente> getPatientById(Long id) { // CRIADA
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> buscarPacientePorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public void deletarPaciente(Long cpf) {
        pacienteRepository.deleteById(cpf);
    }
}
