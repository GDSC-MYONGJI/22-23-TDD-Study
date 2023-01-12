package com.hou27.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
  public LocalDate calculateExpiryDate(PayData payData) {
    int plusMonths = payData.getPayAmount() / 10_000;
    LocalDate newExpiryDate = payData.getBillingDate().plusMonths(plusMonths);
    if(payData.getFirstBillingDate() != null) {
      int expiryMonthDate = newExpiryDate.lengthOfMonth() < payData.getFirstBillingDate().getDayOfMonth() ?
        newExpiryDate.lengthOfMonth() : payData.getFirstBillingDate().getDayOfMonth();

      return newExpiryDate.withDayOfMonth(expiryMonthDate);
    }
    return newExpiryDate;
  }

}
