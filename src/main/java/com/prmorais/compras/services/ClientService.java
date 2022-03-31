package com.prmorais.compras.services;

import com.prmorais.compras.repositories.ClienteRepository;
import com.prmorais.compras.models.Client;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {
  private final ClienteRepository repository;

  public ClientService(ClienteRepository repository) {
    this.repository = repository;
  }

  public Client findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Client> findAll() {
    return repository.findAll();
  }

  @Transactional
  public Client save(Client client) {
    return repository.save(client);
  }

  @Transactional
  public Client update(Long id, Client client) {
    if (repository.findById(id).isPresent()) {
      return repository.save(client);
    }
    return null;
  }

  @Transactional
  public Boolean delete(Long id) {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
