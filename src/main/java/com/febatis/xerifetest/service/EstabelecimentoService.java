package com.febatis.xerifetest.service;

import java.util.List;
import java.util.Optional;

import com.febatis.xerifetest.entity.Estabelecimento;
import com.febatis.xerifetest.repository.EstabelecimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepository;

    public List<Estabelecimento> findAll() {
        return EstabelecimentoRepository.findAll();
    }

    public Optional<Estabelecimento> findById(Long id) {
        return EstabelecimentoRepository.findById(id);
    }

    public Estabelecimento save(Estabelecimento Estabelecimento) {
        return EstabelecimentoRepository.save(Estabelecimento);
    }

    public Estabelecimento update(Estabelecimento Estabelecimento) {
        return EstabelecimentoRepository.save(Estabelecimento);
    }

    public void deleteById(Long id) {
        EstabelecimentoRepository.deleteById(id);
    }
}