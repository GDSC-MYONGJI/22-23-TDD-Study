package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {  // expiry(expiration) date : 만료일

    @Test
    void 십만원을_납부하면_1년_제공(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100_000)
                        .build()
                , LocalDate.of(2020, 1, 28));
    }

    // 1만원을 납부하면 한 달 뒤 같은 날을 만료일로 계산
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
//        // 처음 작성하는 코드
//        assertEquals(기대하는 만료일, 실제 만료일);
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2019, 4, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 5))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2019, 6, 5));
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        // LocalDate#plusMonths() 메서드가 알아서 한 달 추가 처리를 해 줌
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2019, 2, 28));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2019, 6, 30));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2020, 2, 29));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부(){
        // case 1
        PayData payData = PayData.builder()
                .firstBillingData(LocalDate.of(2019, 1, 31))  // 첫 납부일
                .billingDate(LocalDate.of(2019, 2, 28)) // 납부일
                .payAmount(10_000)
                .build();
        assertExpiryDate(payData, LocalDate.of(2019, 3, 31));

        // case 2
        PayData payData2 = PayData.builder()
                .firstBillingData(LocalDate.of(2019, 1, 30))  // 첫 납부일
                .billingDate(LocalDate.of(2019, 2, 28)) // 납부일
                .payAmount(10_000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));

        // case 3
        PayData payData3 = PayData.builder()
                .firstBillingData(LocalDate.of(2019, 5, 31))  // 첫 납부일
                .billingDate(LocalDate.of(2019, 6, 30)) // 납부일
                .payAmount(10_000)
                .build();
        assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));

    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20_000)
                        .build()
                , LocalDate.of(2019, 5, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30_000)
                        .build()
                , LocalDate.of(2019, 6, 1));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부(){
        // case 1
        assertExpiryDate(
                PayData.builder()
                        .firstBillingData(LocalDate.of(2019, 1, 31))  // 첫 납부일
                        .billingDate(LocalDate.of(2019, 2, 28)) // 납부일
                        .payAmount(20_000)
                        .build()
                , LocalDate.of(2019, 4, 30));

        // case 2
        assertExpiryDate(
                PayData.builder()
                        .firstBillingData(LocalDate.of(2019, 3, 31))  // 첫 납부일
                        .billingDate(LocalDate.of(2019, 4, 30)) // 납부일
                        .payAmount(30_000)
                        .build()
                , LocalDate.of(2019, 7, 31));
    }
}
