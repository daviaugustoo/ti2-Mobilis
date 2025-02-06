package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobilis.tis2mobilis.models.Duvida;
import com.mobilis.tis2mobilis.repositories.DuvidaRepository;

@Service
public class DuvidaService {

    private final DuvidaRepository duvidaRepository;

    public DuvidaService(DuvidaRepository duvidaRepository) {
        this.duvidaRepository = duvidaRepository;
    }

    public Duvida salvarDuvida(Duvida duvida) {
        return duvidaRepository.save(duvida);
    }

    public List<Duvida> listarDuvidas() {
        return duvidaRepository.findAll();
    }

    public Optional<Duvida> buscarDuvidaPorId(Long id) {
        return duvidaRepository.findById(id);
    }

    public List<Duvida> buscarDuvidasPorNome(String nome) {
        return duvidaRepository.findByNome(nome);
    }

    public void deletarDuvida(Long id) {
        duvidaRepository.deleteById(id);
    }
}
