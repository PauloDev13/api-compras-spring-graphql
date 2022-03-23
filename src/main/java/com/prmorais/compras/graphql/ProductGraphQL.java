package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.dtos.ProductDTO;
import com.prmorais.compras.services.ProductService;
import com.prmorais.compras.types.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record ProductGraphQL(
    ProductService service
) implements GraphQLQueryResolver, GraphQLMutationResolver {


  public List<Product> products() {
    return service.findAll();
  }

  public Product product(Long id) {
    return service.findById(id);
  }

  public Product saveProduct(ProductDTO productDto) {
    ModelMapper model = new ModelMapper();
    Product product = model.map(productDto, Product.class);
    return service.save(product);
  }

  public Product updateProduct(Long id, ProductDTO productDto) {
    ModelMapper model = new ModelMapper();
    Product product = model.map(productDto, Product.class);
    product.setId(id);
    return service.update(id, product);
  }

  public Boolean deleteProduct(Long id) {
    return service.delete(id);
  }
}
