package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayDate payDate){
        return payDate.getBillingDate().plusMonths(1);
    }
}
