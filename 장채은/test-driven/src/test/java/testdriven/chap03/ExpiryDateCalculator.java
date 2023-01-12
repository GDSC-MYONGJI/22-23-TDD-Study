package testdriven.chap03;


import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData){
        int addedMonths = payData.getPayAmount()/10_000;
        if(payData.getFirstBillingDate() != null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            // 첫 납부 일자(31일)와 후보 만료일의 일자(28일)이 같지 않을때
            if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
               // 후보 만료일(실제 날짜로 확인)이 첫 돈을 낸 일자보다 더 작은 경우에는 후보 만료일의 일자로 return
                if(YearMonth.from(candidateExp).lengthOfMonth()<payData.getFirstBillingDate().getDayOfMonth()){
                    return candidateExp.withDayOfMonth(YearMonth.from(candidateExp).lengthOfMonth());
                }
                // 첫 납부일의 일자를 후보 만료일의 일자로 사용
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}

