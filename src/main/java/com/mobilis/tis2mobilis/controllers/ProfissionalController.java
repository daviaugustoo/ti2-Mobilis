package com.mobilis.tis2mobilis.controllers;

import java.util.List;
import java.util.Optional;

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

import com.mobilis.tis2mobilis.models.Profissional;
import com.mobilis.tis2mobilis.services.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping
    public ResponseEntity<Profissional> criarProfissional(@RequestBody Profissional profissional) {
        Profissional novoProfissional = profissionalService.salvarProfissional(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfissional);
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listarTodosProfissionais() {
        List<Profissional> profissionais = profissionalService.listarTodosProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/id/{id}") //CRIADA
    public ResponseEntity<Optional<Profissional>> getProfessionalById(@RequestBody @PathVariable Long id) {
        Optional<Profissional> professional = profissionalService.getProfessionalById(id);
        if (professional.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(professional);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizarProfissional(@PathVariable Long id, @RequestBody Profissional profissionalAtualizado) {
        Optional<Profissional> profissionalOptional = profissionalService.getProfessionalById(id);

        if (!profissionalOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Profissional profissionalExistente = profissionalOptional.get();
        profissionalExistente.setNumeroTelefone(profissionalAtualizado.getNumeroTelefone());
        profissionalExistente.setSenha(profissionalAtualizado.getSenha());
        profissionalExistente.setNome(profissionalAtualizado.getNome());
        profissionalExistente.setEmail(profissionalAtualizado.getEmail());

        Profissional profissionalAtualizadoFinal = profissionalService.salvarProfissional(profissionalExistente);
        return ResponseEntity.ok(profissionalAtualizadoFinal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id) {
        if (!profissionalService.getProfessionalById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        profissionalService.deletarProfissional(id);
        return ResponseEntity.noContent().build();
    }

}