package com.example.tdd_project.chapter3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExpiryDateCalculatorTest {

    @Test
    void pay_10000_won(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 4, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 6, 1))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 7, 1));
    }

    @Test
    void pay_10000_won_but_different_Date(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 2, 28));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 6, 30));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2020, 2, 29));
    }

    @Test
    void pay_10000_won_firstbilling_billing_different_Date(){
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2019, 3, 31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 30))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));
    }

    @Test
    void pay_20000_won_over_exp_calculate(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019, 5, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30000)
                        .build(),
                LocalDate.of(2019, 6, 1));
    }

    @Test
    void pay_20000_won_over_firstbilling_billing_different_date_exp_calculate(){
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019, 4, 30));
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(40000)
                        .build(),
                LocalDate.of(2019, 6, 30));
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 3, 31))
                        .billingDate(LocalDate.of(2019, 4, 30))
                        .payAmount(30000)
                        .build(),
                LocalDate.of(2019, 7, 31));
    }

    @Test
    void pay_100000_won_then_1year(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020, 1, 28));
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate){
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate expiryDate = calculator.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, expiryDate);
    }

}
