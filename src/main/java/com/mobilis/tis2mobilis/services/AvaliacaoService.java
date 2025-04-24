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

    /*
    Sugestão de melhoria 12:
    Para evitar possíveis erros durante a execução desse método é interessante
    Adicionar validação para verificar se a avaliação não é nula antes de salvá-la.
     */
    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("Avaliação não pode ser nula");
        }
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
