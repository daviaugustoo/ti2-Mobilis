package com.mobilis.tis2mobilis.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilis.tis2mobilis.models.Exercicio;
import com.mobilis.tis2mobilis.repositories.ExercicioRepository;


@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio salvarExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    public List<Exercicio> buscarExerciciosPorCpf(String cpf) {
        return exercicioRepository.findByCpf(cpf);
    }

    public void deletarExerciciosPorCpf(String cpf) {
        exercicioRepository.deleteByCpf(cpf);
    }

    @Transactional
    public Exercicio atualizarNota(Long id, Integer novaNota) {
        Exercicio exercicio = exercicioRepository.findById(id).orElse(null);
        if (exercicio != null) {
            exercicio.setNota(novaNota);
            return exercicioRepository.save(exercicio);
        }
        return null;
    }
    @Transactional
    public Exercicio atualizarStatus(Long id, boolean novoStatus) {
        Exercicio exercicio = exercicioRepository.findById(id).orElse(null);
        if (exercicio != null) {
            exercicio.setStatus(novoStatus);
            return exercicioRepository.save(exercicio);
        }
        return null;
    }
}
