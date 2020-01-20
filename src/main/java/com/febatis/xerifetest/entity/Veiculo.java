package com.febatis.xerifetest.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.febatis.xerifetest.enumeration.VeiculoType;

import lombok.Data;

@Entity
@Data
public class Veiculo {

  @Id
  @GeneratedValue
  private long id;
  private String marca;
  private String cor;
  private String placa;

  @Enumerated(EnumType.STRING)
  private VeiculoType tipo;

}