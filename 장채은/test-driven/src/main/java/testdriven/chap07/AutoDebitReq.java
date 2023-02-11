package testdriven.chap07;

public class AutoDebitReq {
    private String user;
    private String cardNo;

    public AutoDebitReq(String user, String cardNo){
        this.user = user;
        this.cardNo = cardNo;
    }
    public String getCardNumber() {
        return this.cardNo;
    }

    public String getUserId() {
        return this.user;
    }
}
