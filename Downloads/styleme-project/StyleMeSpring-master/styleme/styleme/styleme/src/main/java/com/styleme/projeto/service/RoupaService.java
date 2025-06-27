package com.styleme.projeto.service;

import com.styleme.projeto.entity.Calca;
import com.styleme.projeto.entity.Camisa;
import com.styleme.projeto.entity.Roupa;
import com.styleme.projeto.repository.CalcaRepository;
import com.styleme.projeto.repository.CamisaRepository;
import com.styleme.projeto.repository.RoupaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoupaService {

    private final CamisaRepository camisaRepository;
    private final CalcaRepository calcaRepository;
    private final RoupaRepository roupaRepository;

    public RoupaService(CamisaRepository camisaRepository, CalcaRepository calcaRepository, RoupaRepository roupaRepository) {
        this.camisaRepository = camisaRepository;
        this.calcaRepository = calcaRepository;
        this.roupaRepository = roupaRepository;
    }

    @Transactional
    public Camisa cadastrarCamisa(Camisa camisa) {
        camisaRepository.findByTamanho(camisa.getTamanho()).ifPresent(tamanhoExistente -> {
            camisa.setTorax(tamanhoExistente.getTorax());
            camisa.setTorso(tamanhoExistente.getTorso());
            camisa.setBraco(tamanhoExistente.getBraco());
        });
        return camisaRepository.save(camisa);
    }

    @Transactional
    public Calca cadastrarCalca(Calca calca) {
        calcaRepository.findByTamanho(calca.getTamanho()).ifPresent(tamanhoExistente -> {
            calca.setCintura(tamanhoExistente.getCintura());
            calca.setQuadril(tamanhoExistente.getQuadril());
            calca.setPerna(tamanhoExistente.getPerna());
        });
        return calcaRepository.save(calca);
    }

    @Transactional
    public Roupa cadastrarRoupa(Roupa roupa) {
        // Garante que apenas os atributos não nulos sejam salvos
        if (roupa.getGenero() != '\0') {
            roupa.setGenero(roupa.getGenero());
        }
        if (roupa.getNome() != null && !roupa.getNome().isEmpty()) {
            roupa.setNome(roupa.getNome());
        }
        if (roupa.getValor() > 0) {
            roupa.setValor(roupa.getValor());
        }
        if (roupa.getQuantidade() >= 0) {
            roupa.setQuantidade(roupa.getQuantidade());
        }

        return roupaRepository.save(roupa);
    }
}
