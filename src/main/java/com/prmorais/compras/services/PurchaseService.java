package com.prmorais.compras.services;

import com.prmorais.compras.repositories.PurchaseRepository;
import com.prmorais.compras.types.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
  private final PurchaseRepository repository;

  public Purchase findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Purchase> findAll() {
    return repository.findAll();
  }

  @Transactional
  public Purchase save(Purchase purchase) {
    return repository.save(purchase);
  }

  @Transactional
  public Boolean delete(Long id) {
    if (findById(id) != null) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
