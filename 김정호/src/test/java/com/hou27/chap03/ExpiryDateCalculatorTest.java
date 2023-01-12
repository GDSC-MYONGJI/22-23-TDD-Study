package com.hou27.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
  @Test
  void 만원_납부하면_한달_뒤가_만료일이_됨() {
    LocalDate billingDate1 = LocalDate.of(2019, 3, 1);
    LocalDate billingDate2 = LocalDate.of(2022, 3, 1);
    int payAmount1 = 10_000;
    int payAmount2 = 10_000;
    LocalDate expiryDate1 = LocalDate.of(2019, 4, 1);
    LocalDate expiryDate2 = LocalDate.of(2022, 4, 1);

    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate result1 = cal.calculateExpiryDate(billingDate1, payAmount1);
    LocalDate result2 = cal.calculateExpiryDate(billingDate2, payAmount2);
    assertEquals(expiryDate1, result1);
    assertEquals(expiryDate2, result2);
  }
}
