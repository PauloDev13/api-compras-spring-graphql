package com.prmorais.compras.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneDateUtils {
  private static final String PATTERN = "dd/MM/yyyy HH:mm";
  private static final DateTimeFormatter df = DateTimeFormatter.ofPattern(PATTERN);


  public static String toString(ZonedDateTime date) {
    return df.format(date);
  }

  public static ZonedDateTime toDate(String s) {
      return ZonedDateTime.parse(s);
  }
}
