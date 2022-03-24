package com.prmorais.compras.dtos;

import lombok.Getter;

@Getter
public class PurchaseDTO {
  private Long id;
  private Integer quantity;
  private String status;
  private Long clientId;
  private Long productId;
}
