package com.prmorais.compras.repositories;

import com.prmorais.compras.models.Client;
import com.prmorais.compras.models.Purchase;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

//  @NotNull
//  @Override
//  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
//  Page<Purchase> findAll(@NotNull Pageable pageable);

  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
  List<Purchase> findAllByClient(Client client);
}
