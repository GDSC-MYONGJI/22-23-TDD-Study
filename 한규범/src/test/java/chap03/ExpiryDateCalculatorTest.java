package chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){
        assertExpiryDate(LocalDate.of(2023, 1, 13),10_000,LocalDate.of(2023,2,13));
        assertExpiryDate(LocalDate.of(2023, 3, 13),10_000,LocalDate.of(2023,4,13));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpiryDate(
                LocalDate.of(2019, 1, 31),10_000,
                LocalDate.of(2019,2,28));
        assertExpiryDate(
                LocalDate.of(2019, 5, 31),10_000,
                LocalDate.of(2019,6,30));
        assertExpiryDate(
                LocalDate.of(2020, 1, 31),10_000,
                LocalDate.of(2020,2,29));
    }



    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate exceptedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(exceptedExpiryDate,realExpiryDate);
    }

}
