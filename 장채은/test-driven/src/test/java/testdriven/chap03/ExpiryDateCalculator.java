package testdriven.chap03;


import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount){
        return billingDate.plusMonths(1); // 메서드가 알아서 날짜 주기를 처리해줌
    }

    public LocalDate calculateExpiryDate(PayData payData){
        return payData.getBillingDate().plusMonths(1);
    }
}

