package com.prmorais.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.prmorais.compras.types.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseResolver implements GraphQLResolver<Purchase> {
  public String status(Purchase purchase) {
    return "Teste " + purchase.getStatus();
  }
}
