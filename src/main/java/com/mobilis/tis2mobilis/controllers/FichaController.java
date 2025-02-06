package com.mobilis.tis2mobilis.controllers;

import java.util.List;
import java.util.Map;
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

import com.mobilis.tis2mobilis.models.Ficha;
import com.mobilis.tis2mobilis.services.FichaService;

@RestController
@RequestMapping("/fichas")
public class FichaController {

    private final FichaService fichaService;

    public FichaController(FichaService fichaService) {
        this.fichaService = fichaService;
    }

    @PostMapping
    public ResponseEntity<Ficha> criarFicha(@RequestBody Ficha ficha) {
        Ficha novaFicha = fichaService.salvarFicha(ficha);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFicha);
    }

    @GetMapping
    public ResponseEntity<List<Ficha>> listarFichas() {
        List<Ficha> fichas = fichaService.listarFichas();
        return ResponseEntity.ok(fichas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ficha> buscarFichaPorId(@PathVariable Long id) {
        Optional<Ficha> ficha = fichaService.buscarFichaPorId(id);
        return ficha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Ficha> atualizarNota(@PathVariable String cpf, @RequestBody Map<String, Integer> notaMap) {
        Integer novaNota = notaMap.get("nota");
        if (novaNota == null) {
            return ResponseEntity.badRequest().build();
        }
        Ficha fichaAtualizada = fichaService.atualizarNota(cpf, novaNota);
        if (fichaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fichaAtualizada);
    }

    @PutMapping("/{cpf}/status")
    public ResponseEntity<Ficha> atualizarStatus(@PathVariable String cpf, @RequestBody Map<String, Boolean> statusMap) {
        Boolean status = statusMap.get("status");
        if (status == null) {
            return ResponseEntity.badRequest().build();
        }
        Ficha fichaAtualizada = fichaService.atualizarStatus(cpf, status);
        if (fichaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fichaAtualizada);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarFicha(@PathVariable String cpf) {
        if (!fichaService.buscarFichaPorCpf(cpf).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fichaService.deletarFicha(cpf);
        return ResponseEntity.noContent().build();
    }
}
