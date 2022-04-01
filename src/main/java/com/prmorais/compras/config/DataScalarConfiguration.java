//package com.prmorais.compras.config;
//
//import com.prmorais.compras.utils.DateUtils;
//import graphql.language.StringValue;
//import graphql.schema.*;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Date;
//
//@Configuration
//public class DataScalarConfiguration {
//
//  @Bean
//  public GraphQLScalarType dateScalar() {
//    return GraphQLScalarType.newScalar()
//        .name("Date")
//        .description("Java 17 LocalDate as escalar")
//        .coercing(new Coercing<Date, String>() {
//          @Override
//          public String serialize(@NotNull Object input) {
//            if (input instanceof Date) {
//              return DateUtils.toString((Date) input);
//            }
//            throw new CoercingSerializeException(String.format("Invalid Date: %s", input));
//          }
//
//          @Override
//          public @NotNull Date parseValue(@NotNull Object input) {
//            if (input instanceof String) {
//              Date dt = DateUtils.toDate((String) input);
//
//              if (dt != null) {
//                return dt;
//              }
//            }
//            throw new CoercingParseValueException(String.format("Invalid Date: %s", input));
//          }
//
//          @Override
//          public @NotNull Date parseLiteral(@NotNull Object input) throws CoercingParseLiteralException {
//            if (input instanceof StringValue) {
//              Date dt = DateUtils.toDate(String.valueOf((StringValue) input));
//
//              if (dt != null) {
//                return dt;
//              }
//            }
//            throw new CoercingParseLiteralException("Expected a StringValue");
//          }
//        }).build();
//
//    }
//  }
