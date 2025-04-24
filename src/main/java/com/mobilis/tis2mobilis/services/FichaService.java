package com.mobilis.tis2mobilis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobilis.tis2mobilis.models.Ficha;
import com.mobilis.tis2mobilis.repositories.FichaRepository;

@Service
public class FichaService {

    private final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    public Ficha salvarFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public List<Ficha> listarFichas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> buscarFichaPorId(Long id) {
        return fichaRepository.findById(id);
    }

    public Optional<Ficha> buscarFichaPorCpf(String cpf) {
        return fichaRepository.findByCpf(cpf);
    }

    public void deletarFicha(String cpf) {
        fichaRepository.deleteByCpf(cpf);
    }

    @Transactional
    public Ficha atualizarNota(String cpf, Integer novaNota) {
        Ficha ficha = fichaRepository.findByCpf(cpf).orElse(null);
        if (ficha != null) {
            ficha.setNota(novaNota);
            return fichaRepository.save(ficha);
        }
        return null;
    }

    /*
    Sugestão de melhoria 18:
    Ao invés de simplesmente retornar null, é interessante que a aplicação
    tenha uma identificação de erros mais robusta. Isso pode ser feito através
    do lançamento de exceções específicas para cada tipo de erro, como feito abaixo
    caso o CPF não seja encontrado.
     */
    @Transactional
    public Ficha atualizarStatus(String cpf, boolean status) {
        return fichaRepository.findByCpf(cpf)
                .map(ficha -> {
                    ficha.setStatus(status);
                    return fichaRepository.save(ficha);
                })
                .orElseThrow(() -> new RuntimeException("Ficha não encontrada para CPF: " + cpf));
    }

}
