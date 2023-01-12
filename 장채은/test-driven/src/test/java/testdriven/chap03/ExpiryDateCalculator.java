package testdriven.chap03;


import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData){
        int addedMonths = payData.getPayAmount()/10_000;
        if(payData.getFirstBillingDate() != null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            // 첫 납부 일자(31일)와 후보 만료일의 일자(28일)이 같지 않을때
            if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
                // 첫 납부일의 일자를 후보 만료일의 일자로 사용
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}

