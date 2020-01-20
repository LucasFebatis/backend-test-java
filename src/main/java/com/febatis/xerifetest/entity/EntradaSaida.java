package com.febatis.xerifetest.entity;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class EntradaSaida {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  private Estabelecimento estabelecimento;

  @ManyToOne(fetch = FetchType.EAGER)
  private Veiculo veiculo;

  private OffsetDateTime horaEntrada;
  private OffsetDateTime horaSaida;
  
}

