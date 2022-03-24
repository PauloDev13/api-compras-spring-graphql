package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.dtos.ClientDTO;
import com.prmorais.compras.services.ClientService;
import com.prmorais.compras.types.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClientGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  private final ClientService service;

  public ClientGraphQL(ClientService service) {
    this.service = service;
  }

  public Client getClient(Long id) {
    return service.findById(id);
  }

  public List<Client> getClients() {
    return service.findAll();
  }

  public Client saveClient(ClientDTO clientDto) {
    ModelMapper mapper = new ModelMapper();
    Client client = mapper.map(clientDto, Client.class);
    return service.save(client);
  }

  public Client updateClient(Long id, ClientDTO clientDto) {
    ModelMapper mapper = new ModelMapper();
    Client client = mapper.map(clientDto, Client.class);
    client.setId(id);
    return service.update(id, client);
  }

  public Boolean deleteClient(Long id) {
    return service.delete(id);
  }
}
