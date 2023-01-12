package com.hou27.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
  public LocalDate calculateExpiryDate(PayData payData) {
    if(payData.getFirstBillingDate() != null) {
      return payData.getBillingDate().plusMonths(1).withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
    }
    if(payData.getPayAmount() >= 20_000) {
      return payData.getBillingDate().plusMonths(payData.getPayAmount() / 10_000);
    }
    return payData.getBillingDate().plusMonths(1);
  }

}
