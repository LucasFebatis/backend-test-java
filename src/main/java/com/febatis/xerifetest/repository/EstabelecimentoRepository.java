package com.febatis.xerifetest.repository;

import com.febatis.xerifetest.entity.Estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{}