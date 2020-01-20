package com.febatis.xerifetest.repository;

import com.febatis.xerifetest.entity.EntradaSaida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long>{}