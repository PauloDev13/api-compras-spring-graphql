package com.prmorais.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.prmorais.compras.types.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver implements GraphQLResolver<Product> {

  public String priceInReal(Product product) {
    return "R$ " + product.getPrice().toString();
  }

}
