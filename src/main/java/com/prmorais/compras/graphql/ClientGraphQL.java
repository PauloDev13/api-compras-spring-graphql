package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.repositories.ClienteRepository;
import com.prmorais.compras.types.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientGraphQL implements GraphQLQueryResolver {

  private final ClienteRepository repository;

  public ClientGraphQL(ClienteRepository repository) {
    this.repository = repository;
  }

  public Client getClient(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Client> getClients() {
    return repository.findAll();
  }
}
