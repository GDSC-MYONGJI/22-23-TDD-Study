package testdriven.chap03;


import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount){
        return billingDate.plusMonths(1); // 메서드가 알아서 날짜 주기를 처리해줌
    }

    public LocalDate calculateExpiryDate(PayData payData){
        if(payData.getFirstBillingDate() != null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
            // 첫 납부 일자(31일)와 후보 만료일의 일자(28일)이 같지 않을때
            if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
                // 첫 납부일의 일자를 후보 만료일의 일자로 사용
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(1);
    }
}

