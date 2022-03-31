package com.prmorais.compras.graphql.resolvers.fields;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.prmorais.compras.services.ClientService;
import com.prmorais.compras.services.ProductService;
import com.prmorais.compras.models.Client;
import com.prmorais.compras.models.Product;
import com.prmorais.compras.models.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseResolver implements GraphQLResolver<Purchase> {

  private final ClientService cliService;
  private final ProductService prodService;

  public String status(Purchase purchase) {
    return "Teste " + purchase.getStatus();
  }

  public Client client(Purchase purchase) {
    return cliService.findById(purchase.getClient().getId());
  }

  public Product product(Purchase purchase) {
    return prodService.findById(purchase.getProduct().getId());
  }
}
