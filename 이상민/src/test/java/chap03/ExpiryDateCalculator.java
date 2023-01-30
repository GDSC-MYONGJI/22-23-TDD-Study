package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;

        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData,addedMonths);
        }else{
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths){
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths); // 후보 만료일
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

        if(dayOfFirstBilling != candidateExp.getDayOfMonth()){ // 첫 납부일의 일자와 후보 만료일의 일자가 다르면
            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            if(dayLenOfCandiMon < dayOfFirstBilling){  // 후보 만료일이 포함된 달의 마지막 날 < 첫 납부일의 일자
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling); // 첫 납부일의 일자를 후보 만료일의 일자로 사용
        }else{
            return candidateExp;
        }
    }
}
