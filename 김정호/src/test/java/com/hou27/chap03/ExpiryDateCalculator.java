package com.hou27.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
  public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
//    return LocalDate.of(2019, 4, 1);
    return billingDate.plusMonths(1);
  }

}
