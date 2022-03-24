package com.prmorais.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prmorais.compras.dtos.PurchaseDTO;
import com.prmorais.compras.services.ClientService;
import com.prmorais.compras.services.ProductService;
import com.prmorais.compras.services.PurchaseService;
import com.prmorais.compras.types.Purchase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PurchaseGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
  private final PurchaseService service;
  private final ClientService cliService;
  private final ProductService prodService;

  public Purchase purchase(Long id) {
    return service.findById(id);
  }

  public List<Purchase> purchases() {
    return service.findAll();
  }

  public Purchase savePurchase(PurchaseDTO purchaseDto) {
    ModelMapper mapper = new ModelMapper();

    Purchase purchase = mapper.map(purchaseDto, Purchase.class);
    purchase.setDate(new Date());
    purchase.setClient(cliService.findById(purchaseDto.getClientId()));
    purchase.setProduct(prodService.findById(purchaseDto.getProductId()));

    return service.save(purchase);
  }

  public Boolean deletePurchase(Long id) {
    return service.delete(id);
  }
}
