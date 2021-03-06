package com.prmorais.compras.graphql.resolvers.fields;

import com.prmorais.compras.models.Purchase;
import com.prmorais.compras.services.PurchaseService;
import com.prmorais.compras.models.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientResolver implements GraphQLResolver<Client> {

  private final PurchaseService service;

  public List<Purchase> purchases(Client client) {
    return service.findAllByClient(client);
  }
}
