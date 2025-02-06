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

import com.mobilis.tis2mobilis.models.Avaliacao;
import com.mobilis.tis2mobilis.services.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        Avaliacao novaAvaliacao = avaliacaoService.salvarAvaliacao(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaliacao);
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes() {
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Avaliacao>> buscarAvaliacoesPorNome(@RequestParam String nome) {
        List<Avaliacao> avaliacoes = avaliacaoService.buscarAvaliacoesPorNome(nome);
        if (avaliacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Avaliacao> buscarAvaliacaoPorCpf(@PathVariable String cpf) {
        Optional<Avaliacao> avaliacao = avaliacaoService.buscarAvaliacaoPorCpf(cpf);
        return avaliacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable String cpf, @RequestBody Avaliacao avaliacaoAtualizada) {
        Optional<Avaliacao> avaliacaoOptional = avaliacaoService.buscarAvaliacaoPorCpf(cpf);

        if (!avaliacaoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Avaliacao avaliacaoExistente = avaliacaoOptional.get();
        avaliacaoExistente.setCpf(avaliacaoAtualizada.getCpf());
      
        avaliacaoExistente.setTermino(avaliacaoAtualizada.getTermino());
        avaliacaoExistente.setNome(avaliacaoAtualizada.getNome());
        avaliacaoExistente.setAvaliacao(avaliacaoAtualizada.getAvaliacao());
        avaliacaoExistente.setTitulo(avaliacaoAtualizada.getTitulo());
        

        Avaliacao avaliacaoAtualizadaFinal = avaliacaoService.salvarAvaliacao(avaliacaoExistente);
        return ResponseEntity.ok(avaliacaoAtualizadaFinal);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable String cpf) {
        if (!avaliacaoService.buscarAvaliacaoPorCpf(cpf).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        avaliacaoService.deletarAvaliacaoPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
