package com.hou27.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
  @Test
  void 만원_납부하면_한달_뒤가_만료일이_됨() {
    assertExpiryDate(LocalDate.of(2019, 3, 1), 10_000, LocalDate.of(2019, 4, 1));
    assertExpiryDate(LocalDate.of(2022, 3, 1), 10_000, LocalDate.of(2022, 4, 1));
  }

  private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate result = cal.calculateExpiryDate(billingDate, payAmount);
    assertEquals(expiryDate, result);
  }
}
