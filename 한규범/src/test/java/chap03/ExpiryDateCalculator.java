package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator{
    public LocalDate calculateExpiryDate(PayDate payDate){
        int addedMonths = payDate.getPayAmount() == 100_000 ?
                12 : payDate.getPayAmount() / 10_000;

        if (payDate.getFirstBillingDate() != null){
            LocalDate candidateExp =
                    payDate.getBillingDate().plusMonths(addedMonths);
            final int dayOfFirstBilling = payDate.getFirstBillingDate().getDayOfMonth();
            if (dayOfFirstBilling != candidateExp.getDayOfMonth()){
                final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < dayOfFirstBilling){
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }
                return candidateExp.withDayOfMonth(dayOfFirstBilling);
            }
        }
        return payDate.getBillingDate().plusMonths(addedMonths);
    }
}
