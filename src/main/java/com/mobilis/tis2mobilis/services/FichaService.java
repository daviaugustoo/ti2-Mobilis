package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilis.tis2mobilis.models.Ficha;
import com.mobilis.tis2mobilis.repositories.FichaRepository;

@Service
public class FichaService {

    private final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    public Ficha salvarFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public List<Ficha> listarFichas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> buscarFichaPorId(Long id) {
        return fichaRepository.findById(id);
    }

    public Optional<Ficha> buscarFichaPorCpf(String cpf) {
        return fichaRepository.findByCpf(cpf);
    }

    public void deletarFicha(String cpf) {
        fichaRepository.deleteByCpf(cpf);
    }

    @Transactional
    public Ficha atualizarNota(String cpf, Integer novaNota) {
        Ficha ficha = fichaRepository.findByCpf(cpf).orElse(null);
        if (ficha != null) {
            ficha.setNota(novaNota);
            return fichaRepository.save(ficha);
        }
        return null;
    }
    @Transactional
    public Ficha atualizarStatus(String cpf, boolean status) {
        Ficha ficha = fichaRepository.findByCpf(cpf).orElse(null);
        if (ficha != null) {
            ficha.setStatus(status);
            return fichaRepository.save(ficha);
        }
        return null;
    }

}
