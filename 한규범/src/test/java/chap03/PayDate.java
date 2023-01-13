package chap03;

import java.time.LocalDate;

public class PayDate {

    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;

    public PayDate() {
    }

    public PayDate(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private PayDate data = new PayDate();

        public Builder firstBillingDate(LocalDate firstBillingDate){
            data.firstBillingDate = firstBillingDate;
            return this;
        }

        public Builder billingDate(LocalDate billingDate){
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount){
            data.payAmount = payAmount;
            return this;
        }

        public PayDate build(){
            return data;
        }
    }
}
