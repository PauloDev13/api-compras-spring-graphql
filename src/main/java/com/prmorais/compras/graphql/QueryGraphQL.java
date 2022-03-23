package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.types.Client;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {
  public String hello() {
    return "Hello GraphQL";
  }

  public int soma(int a, int b) {
    return a + b;
  }

  public Client getClient() {
    return new Client("Paulo", "prmorais1302@gmail.com");
  }

  public List<Client> getClients() {
    Client c = new Client("Paulo", "prmorais1302@gmail.com");
    Client c1 = new Client("Patricia", "patricia11@gmail.com");
    Client c2 = new Client("Fernanda", "nanda04@gmail.com");

    return Arrays.asList(c, c1, c2);
  }
}
