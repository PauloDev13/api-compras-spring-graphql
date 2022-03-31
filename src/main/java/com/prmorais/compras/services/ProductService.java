package com.prmorais.compras.services;

import com.prmorais.compras.repositories.ProductRepository;
import com.prmorais.compras.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Transactional
  public Product save(Product product) {
    return repository.save(product);
  }

  public Product update(Long id, Product product) {
    if (findById(id) != null) {
      return repository.save(product);
    }
    return null;
  }

  @Transactional
  public Boolean delete(Long id) {
    Product product = findById(id);
    if (product != null) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
