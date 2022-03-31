package com.prmorais.compras.services;

import com.prmorais.compras.graphql.exception.DomainException;
import com.prmorais.compras.repositories.ClienteRepository;
import com.prmorais.compras.models.Client;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
  private final ClienteRepository repository;

  public ClientService(ClienteRepository repository) {
    this.repository = repository;
  }

  public Client findById(Long id) {
    Optional<Client> client =  repository.findById(id);

    if (client.isEmpty()) {
      throw new DomainException(String.format("Cliente com ID {%s} não cadastrado", id));
    }
    return client.get();
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
    Client clientFind = findById(id);

    if (client.getName() == null || client.getName().equals("")) {
      client.setName(clientFind.getName());
    }

    if (client.getEmail() == null || client.getEmail().equals("")) {
      client.setEmail(clientFind.getEmail());
    }

    return repository.save(client);
  }

  @Transactional
  public Boolean delete(Long id) {
    findById(id);
    repository.deleteById(id);
    return true;
  }
}
