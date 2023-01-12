package com.hou27.chap03;

import java.time.LocalDate;

public class PayData {
  private LocalDate billingDate;
  private int payAmount;

  private PayData() {};

  public PayData(LocalDate billingDate, int payAmount) {
    this.billingDate = billingDate;
    this.payAmount = payAmount;
  }

  public LocalDate getBillingDate() {
    return billingDate;
  }

  public int getPayAmount() {
    return payAmount;
  }

  /*
   * billingDate와 payAmount를 설정하는 것을 쉽게 알 수 있도록
   * builder pattern을 적용
   */
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private PayData data = new PayData();

    public Builder billingDate(LocalDate billingDate) {
      data.billingDate = billingDate;
      return this;
    }

    public Builder payAmount(int payAmount) {
      data.payAmount = payAmount;
      return this;
    }

    public PayData build() {
      return data;
    }
  }

}
