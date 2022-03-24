package com.prmorais.compras.types;

import com.prmorais.compras.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer quantity;
  private String status;
  private Date date;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "client_id", nullable = true)
  private Client client;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id", nullable = true)
  private Product product;
}