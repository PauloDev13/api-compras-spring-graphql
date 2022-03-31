package com.prmorais.compras.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
public class Client implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
}
