package com.febatis.xerifetest.entity;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Estabelecimento {

  @Id
  @GeneratedValue
  private Long id;
  private Long idEstabelecimento;
  private Long idVeiculo;
  private OffsetDateTime horaEntrada;
  private OffsetDateTime horaSaida;

}