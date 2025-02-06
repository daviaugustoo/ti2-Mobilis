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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobilis.tis2mobilis.models.Duvida;
import com.mobilis.tis2mobilis.services.DuvidaService;

@RestController
@RequestMapping("/duvidas")
public class DuvidaController {

    private final DuvidaService duvidaService;

    public DuvidaController(DuvidaService duvidaService) {
        this.duvidaService = duvidaService;
    }

    @PostMapping
    public ResponseEntity<Duvida> criarDuvida(@RequestBody Duvida duvida) {
        Duvida novaDuvida = duvidaService.salvarDuvida(duvida);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDuvida);
    }

    @GetMapping
    public ResponseEntity<List<Duvida>> listarDuvidas() {
        List<Duvida> duvidas = duvidaService.listarDuvidas();
        return ResponseEntity.ok(duvidas);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Duvida>> buscarDuvidasPorNome(@RequestParam String nome) {
        List<Duvida> duvidas = duvidaService.buscarDuvidasPorNome(nome);
        if (duvidas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(duvidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duvida> buscarDuvidaPorId(@PathVariable Long id) {
        Optional<Duvida> duvida = duvidaService.buscarDuvidaPorId(id);
        return duvida.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Duvida> atualizarDuvida(@PathVariable Long id, @RequestBody Duvida duvidaAtualizada) {
        Optional<Duvida> duvidaOptional = duvidaService.buscarDuvidaPorId(id);

        if (!duvidaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Duvida duvidaExistente = duvidaOptional.get();
        duvidaExistente.setTitulo(duvidaAtualizada.getTitulo());
        duvidaExistente.setNome(duvidaAtualizada.getNome());
        duvidaExistente.setDuvida(duvidaAtualizada.getDuvida());
        duvidaExistente.setResposta(duvidaAtualizada.getResposta());

        Duvida duvidaAtualizadaFinal = duvidaService.salvarDuvida(duvidaExistente);
        return ResponseEntity.ok(duvidaAtualizadaFinal);
    }

    @PutMapping("/{id}/nota")
public ResponseEntity<Duvida> atualizarNotaDaDuvida(@PathVariable Long id, @RequestParam Integer nota) {
    Optional<Duvida> duvidaOptional = duvidaService.buscarDuvidaPorId(id);

    if (!duvidaOptional.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    Duvida duvidaExistente = duvidaOptional.get();
    duvidaExistente.setNota(nota);

    Duvida duvidaAtualizada = duvidaService.salvarDuvida(duvidaExistente);
    return ResponseEntity.ok(duvidaAtualizada);
}

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDuvida(@PathVariable Long id) {
        if (!duvidaService.buscarDuvidaPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        duvidaService.deletarDuvida(id);
        return ResponseEntity.noContent().build();
    }
}
