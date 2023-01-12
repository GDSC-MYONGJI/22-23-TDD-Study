package testdriven.chap03;

import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;
    private PayData(){}

    public PayData(LocalDate billingDate, int payAmount){
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate(){
        return billingDate;
    }
    public int getPayAmount(){
        return payAmount;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private PayData payData = new PayData();

        public Builder billingDate(LocalDate billingDate){
            payData.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount){
            payData.payAmount = payAmount;
            return this;
        }

        public PayData build(){
            return payData;
        }
    }
}
