package com.prmorais.compras.graphql.resolvers.fields;

import com.prmorais.compras.models.Product;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver implements GraphQLResolver<Product> {

  public String priceInReal(Product product) {
    return "R$ " + product.getPrice().toString();
  }

}
