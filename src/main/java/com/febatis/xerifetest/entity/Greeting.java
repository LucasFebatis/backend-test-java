package com.febatis.xerifetest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Greeting {

  @Id
  @GeneratedValue
  private long id;
  private String content;

}