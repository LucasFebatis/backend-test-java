package com.febatis.xerifetest.entity;

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
  private String nome;
  private String cnpj;
  private String endereco;
  private String telefone;
  private Integer qtdMoto;
  private Integer qtdCarro;

}