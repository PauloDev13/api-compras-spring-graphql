package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.repositories.ClienteRepository;
import com.prmorais.compras.types.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

  private final ClienteRepository repository;

  public QueryGraphQL(ClienteRepository repository) {
    this.repository = repository;
  }

  public String hello() {
    return "Hello GraphQL";
  }

  public int soma(int a, int b) {
    return a + b;
  }

  public Client getClient(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Client> getClients() {
    return repository.findAll();
  }
}
