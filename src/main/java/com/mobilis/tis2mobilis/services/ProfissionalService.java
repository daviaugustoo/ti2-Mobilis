package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobilis.tis2mobilis.models.Profissional;
import com.mobilis.tis2mobilis.repositories.ProfissionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProfissionalService {

    private static final Logger logger = LoggerFactory.getLogger(ProfissionalService.class);

    @Autowired
    private ProfissionalRepository profissionalRepository;

    /*
    Sugestão de melhoria 17:
    Para facilitar o debug é essencial que exista
    um log que contenha informações relevantes acerca do status das ações dos métodos.
    Dessa forma, durante o debug fica bem mais fácil de ver o que está aconteccendo na aplicação.
     */
    public Profissional salvarProfissional(Profissional profissional) {
        logger.info("Salvando profissional: {}", profissional.getNome());
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