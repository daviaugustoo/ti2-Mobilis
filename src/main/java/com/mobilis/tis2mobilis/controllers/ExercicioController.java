package com.mobilis.tis2mobilis.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilis.tis2mobilis.models.Exercicio;
import com.mobilis.tis2mobilis.services.ExercicioService;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public ResponseEntity<Exercicio> criarExercicio(@RequestBody Exercicio exercicio) {
        Exercicio novaExercicio = exercicioService.salvarExercicio(exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaExercicio);
    }

    @GetMapping
    public ResponseEntity<List<Exercicio>> listarExercicios() {
        List<Exercicio> exercicios = exercicioService.listarExercicios();
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<Exercicio>> buscarExerciciosPorCpf(@PathVariable String cpf) {
        List<Exercicio> exercicios = exercicioService.buscarExerciciosPorCpf(cpf);
        if (exercicios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercicios);
    }


    /*
    Sugestão de melhoria 14:
    O nome da variável requestMap está pouco intuitivo e isso prejudica
    a legibilidade. Usar nomes significativos para os métodos e atributos
    é fundamental para melhorar a legibilidade e o entendimento sobre qual
    o papel de cada atributo e variável no código.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizarNota(@PathVariable Long id, @RequestBody Map<String, Object> dadosAtualizacao) {
        Integer novaNota = (Integer) dadosAtualizacao.get("nota_exercicio");
        Exercicio exercicioAtualizado = exercicioService.atualizarNota(id, novaNota);
        if (exercicioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercicioAtualizado);
    }


    /*
    Sugestão de melhoria 13
    O endpoint da requisição está incorreto,
    já que o CPF é utilizado para atualizar o status do exercício.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<Exercicio> atualizarStatus(@PathVariable Long id, @RequestBody Map<String, Object> requestMap) {
        boolean novoStatus = (boolean) requestMap.get("status_exercicio");
        Exercicio exercicioAtualizado = exercicioService.atualizarStatus(id, novoStatus);
        if (exercicioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercicioAtualizado);
    }


    

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable String cpf) {
        List<Exercicio> exercicios = exercicioService.buscarExerciciosPorCpf(cpf);
        if (exercicios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        exercicioService.deletarExerciciosPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
