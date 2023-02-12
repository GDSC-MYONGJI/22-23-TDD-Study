package testdriven.chap07.validCard;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNo;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime now) {
        this.userId = userId;
        this.cardNo = cardNumber;
    }

    public String getUserIdx(){
        return this.userId;
    }

    public String getCardNumber(){
        return cardNo;
    }

    public void changeCardNumber(String cardNumber) {
        this.cardNo = cardNumber;
    }
}
