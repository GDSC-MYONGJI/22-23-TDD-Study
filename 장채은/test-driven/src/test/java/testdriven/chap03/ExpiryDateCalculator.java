package testdriven.chap03;


import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        // 첫 납부 일자(31일)와 후보 만료일의 일자(28일)이 같지 않을때
        if (isSameDayOfMonth(candidateExp, dayOfFirstBilling)) {
            // 후보 만료일(실제 날짜로 확인)이 첫 돈을 낸 일자보다 더 작은 경우에는 후보 만료일의 일자로 return
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            // 첫 납부일의 일자를 후보 만료일의 일자로 사용
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        }else{
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate candidateExp, int dayOfFirstBilling) {
        return dayOfFirstBilling != candidateExp.getDayOfMonth();
    }
    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}

