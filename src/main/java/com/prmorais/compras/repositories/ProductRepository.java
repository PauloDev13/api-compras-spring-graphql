package com.prmorais.compras.repositories;

import com.prmorais.compras.models.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @NotNull
  @Override
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
  List<Product> findAll();
}
