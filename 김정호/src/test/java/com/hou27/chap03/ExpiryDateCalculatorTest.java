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

  @Test
  void 첫_납부일과_만료일의_일자가_같지_않을_때_1만_원_납부_시_첫_납부일_기준으로_다음_만료일을_정함() {
    PayData payData1 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 31))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    PayData payData2 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 5, 31))
        .billingDate(LocalDate.of(2019, 6, 30))
        .payAmount(10_000)
        .build();
    PayData payData3 = PayData.builder()
        .firstBillingDate(LocalDate.of(2020, 1, 30))
        .billingDate(LocalDate.of(2020, 2, 29))
        .payAmount(10_000)
        .build();
    assertExpiryDate(payData1, LocalDate.of(2019, 3, 31));
    assertExpiryDate(payData2, LocalDate.of(2019, 7, 31));
    assertExpiryDate(payData3, LocalDate.of(2020, 3, 30));
  }

  @Test
  void 이만_원_이상_납부_시_비례해서_만료일_계산() {
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2019, 1, 31))
            .payAmount(20_000)
            .build(),
        LocalDate.of(2019, 3, 31));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2019, 5, 31))
            .payAmount(40_000)
            .build(),
        LocalDate.of(2019, 9, 30));
    assertExpiryDate(PayData.builder()
            .billingDate(LocalDate.of(2020, 1, 31))
            .payAmount(60_000)
            .build(),
        LocalDate.of(2020, 7, 31));
  }

  @Test
  void 첫_납부일과_만료일_일자가_다른_경우_이만_원_이상_납부_시_비례해서_만료일_계산() {
    PayData payData1 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 31))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(20_000)
        .build();
    PayData payData2 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 5, 31))
        .billingDate(LocalDate.of(2019, 6, 30))
        .payAmount(40_000)
        .build();
    PayData payData3 = PayData.builder()
        .firstBillingDate(LocalDate.of(2020, 1, 30))
        .billingDate(LocalDate.of(2020, 2, 29))
        .payAmount(60_000)
        .build();
    assertExpiryDate(payData1, LocalDate.of(2019, 4, 30));
    assertExpiryDate(payData2, LocalDate.of(2019, 10, 31));
    assertExpiryDate(payData3, LocalDate.of(2020, 8, 30));
  }


  private void assertExpiryDate(PayData payData, LocalDate expiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate result = cal.calculateExpiryDate(payData);
    assertEquals(expiryDate, result);
  }
}
