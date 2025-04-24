package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

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

    /*
    Sugestão de melhoria 16:
    Para evitar possíveis erros de NullPointerException durante a execução
    do método, é recomendado que os retornos utilizem Optional. Dessa forma,
    o código obriga o desenvolvedor a tratar a possibilidade de existir um valor null,
    reduzindo significativamente o risco de falhas caso alguma validação seja
    esquecida durante o desenvolvimento.
     */
    @Transactional
    public Optional<Exercicio> atualizarNota(Long id, Integer novaNota) {
        return exercicioRepository.findById(id)
                .map(exercicio -> {
                    exercicio.setNota(novaNota);
                    return exercicioRepository.save(exercicio);
                });
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
