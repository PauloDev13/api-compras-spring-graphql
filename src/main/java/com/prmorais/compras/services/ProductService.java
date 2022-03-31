package com.prmorais.compras.services;

import com.prmorais.compras.graphql.exception.DomainException;
import com.prmorais.compras.repositories.ProductRepository;
import com.prmorais.compras.models.Product;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    Optional<Product> product = repository.findById(id);

    if (product.isEmpty()) {
      throw new DomainException(String.format("Produto com ID %s não cadastrado", id));
    }
    return product.get();
  }

  @Transactional
  public Product save(Product product) {
    return repository.save(product);
  }

  public Product update(Long id, @NotNull Product product) {
    Product productFind = findById(id);

    if (product.getName() == null || product.getName().equals("")) {
      product.setName(productFind.getName());
    }

    if (product.getPrice() == null) {
      product.setPrice(productFind.getPrice());
    }
    return repository.save(product);

  }

  @Transactional
  public Boolean delete(Long id) {
    findById(id);
    repository.deleteById(id);
    return true;
  }
}
