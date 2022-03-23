package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.dtos.ClientDTO;
import com.prmorais.compras.repositories.ClienteRepository;
import com.prmorais.compras.types.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClientGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  private final ClienteRepository repository;

  public ClientGraphQL(ClienteRepository repository) {
    this.repository = repository;
  }

  public Client getClient(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Client> getClients() {
    return repository.findAll();
  }

  @Transactional
  public Client saveClient(ClientDTO clientDto) {
    ModelMapper mapper = new ModelMapper();
    Client client = mapper.map(clientDto, Client.class);
    return repository.save(client);
  }

  @Transactional
  public Client updateClient(Long id, ClientDTO clientDto) {
    if (repository.findById(id).isPresent()) {
      ModelMapper mapper = new ModelMapper();
      Client client = mapper.map(clientDto, Client.class);
      client.setId(id);
      return repository.save(client);
    }
    return null;
  }

  @Transactional
  public Boolean deleteClient(Long id) {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
