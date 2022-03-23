package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.types.Client;
import org.springframework.stereotype.Component;

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
}
