package com.hou27.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
  public LocalDate calculateExpiryDate(PayData payData) {
    if(payData.getFirstBillingDate() != null) {
      return payData.getBillingDate().plusMonths(1).withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
    }
    return payData.getBillingDate().plusMonths(1);
  }

}
