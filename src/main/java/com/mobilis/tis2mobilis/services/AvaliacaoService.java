package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobilis.tis2mobilis.models.Avaliacao;
import com.mobilis.tis2mobilis.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Optional<Avaliacao> buscarAvaliacaoPorCpf(String cpf) {
        return avaliacaoRepository.findByCpf(cpf);
    }

    public List<Avaliacao> buscarAvaliacoesPorNome(String nome) {
        return avaliacaoRepository.findByNomeContaining(nome);
    }

    public void deletarAvaliacaoPorCpf(String cpf) {
        avaliacaoRepository.deleteByCpf(cpf);
    }
}
