package com.prmorais.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiComprasApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiComprasApplication.class, args);
  }

}
