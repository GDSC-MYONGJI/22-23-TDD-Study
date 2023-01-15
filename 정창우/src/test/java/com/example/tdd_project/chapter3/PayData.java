package com.example.tdd_project.chapter3;

import net.bytebuddy.jar.asm.ClassReader;

import java.time.LocalDate;

public class PayData {
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmmount;

    private PayData(){}

    public PayData(LocalDate firstBillingDate, LocalDate billingDate, int payAmmount){
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmmount = payAmmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmmount() {
        return payAmmount;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate){
            data.billingDate = billingDate;
            return this;
        }
        public Builder payAmount(int payAmount){
            data.payAmmount = payAmount;
            return this;
        }
        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.firstBillingDate = firstBillingDate;
            return this;
        }
        public PayData build(){
            return data;
        }
    }

}
