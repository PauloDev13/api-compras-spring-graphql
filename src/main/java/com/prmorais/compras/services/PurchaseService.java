package com.prmorais.compras.services;

import com.prmorais.compras.graphql.exception.DomainException;
import com.prmorais.compras.models.Purchase;
import com.prmorais.compras.repositories.PurchaseRepository;
import com.prmorais.compras.models.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {
  private final PurchaseRepository repository;

  public Purchase findById(Long id) {
    Optional<Purchase> purchase = repository.findById(id);

    if (purchase.isEmpty()) {
      throw new DomainException(String.format("Compra com ID { %s } não cadastrada", id));
    }
    return purchase.get();
  }

  public List<Purchase> findAll(PageRequest pageable) {
    return repository.findAll(pageable).getContent();
  }

  @Transactional
  public Purchase save(Purchase purchase) {
    return repository.save(purchase);
  }

  @Transactional
  public Boolean delete(Long id) {
    findById(id);
    repository.deleteById(id);
    return true;
  }

  public List<Purchase> findAllByClient(Client client) {
    return repository.findAllByClient(client);
  }
}
