package testdriven.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expiryDate, LocalDate.of(2019, 4, 1));

        LocalDate billingDate2 = LocalDate.of(2019, 5, 5);
        int payAmount2 = 10_000;
        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);
        assertEquals(expiryDate2, LocalDate.of(2019, 6, 5));
    }
}
