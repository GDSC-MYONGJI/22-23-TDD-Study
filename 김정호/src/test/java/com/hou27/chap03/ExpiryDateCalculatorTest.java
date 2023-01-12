package com.hou27.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
  @Test
  void 만원_납부하면_한달_뒤가_만료일이_됨() {
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2019, 3, 1))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2019, 4, 1));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2022, 3, 1))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2022, 4, 1));
  }

  @Test
  void 납부일과_한달_뒤_일자가_같지_않음() {
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2019, 1, 31))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2019, 2, 28));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2019, 5, 31))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2019, 6, 30));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 1, 31))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2020, 2, 29));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 5, 31))
            .payAmount(10_000)
            .build(),
        LocalDate.of(2020, 6, 30));
  }

  private void assertExpiryDate(PayData payData, LocalDate expiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate result = cal.calculateExpiryDate(payData);
    assertEquals(expiryDate, result);
  }
}
