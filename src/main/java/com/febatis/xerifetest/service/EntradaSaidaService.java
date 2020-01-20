package com.febatis.xerifetest.service;

import java.util.List;
import java.util.Optional;

import com.febatis.xerifetest.entity.EntradaSaida;
import com.febatis.xerifetest.repository.EntradaSaidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaSaidaService {

    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    public List<EntradaSaida> findAll() {
        return entradaSaidaRepository.findAll();
    }

    public Optional<EntradaSaida> findById(Long id) {
        return entradaSaidaRepository.findById(id);
    }

    public EntradaSaida save(EntradaSaida entradaSaida) {
        return entradaSaidaRepository.save(entradaSaida);
    }

    public EntradaSaida update(EntradaSaida entradaSaida) {
        return entradaSaidaRepository.save(entradaSaida);
    }

    public void deleteById(Long id) {
        entradaSaidaRepository.deleteById(id);
    }
}