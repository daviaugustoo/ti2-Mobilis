package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobilis.tis2mobilis.models.Profissional;
import com.mobilis.tis2mobilis.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional salvarProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public List<Profissional> listarTodosProfissionais() {
        return profissionalRepository.findAll();
    }

    /*public Optional<Profissional> buscarProfissionalPorCodigo(Long codigoProfissional) {
        return profissionalRepository.findById(codigoProfissional);
    }*/

    public Optional<Profissional> getProfessionalById(Long id) {
        return profissionalRepository.findById(id);
    }

    public void deletarProfissional(Long codigoProfissional) {
        profissionalRepository.deleteById(codigoProfissional);
    }

    public boolean existeProfissional(Long codigoProfissional) {
        return profissionalRepository.existsById(codigoProfissional);
    }
}