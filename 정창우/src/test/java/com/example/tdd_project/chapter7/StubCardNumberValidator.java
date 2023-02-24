package com.example.tdd_project.chapter7;

public class StubCardNumberValidator extends CardNumberValidator {
    private String invalidNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    @Override
    public CardVality validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidy.INVALID;
        }
        return CardValidy.VALID;
    }
}
