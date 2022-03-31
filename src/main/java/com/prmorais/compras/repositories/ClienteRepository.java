package com.prmorais.compras.repositories;

import com.prmorais.compras.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {}
