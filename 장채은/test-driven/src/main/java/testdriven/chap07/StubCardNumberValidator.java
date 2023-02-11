package testdriven.chap07;

public class StubCardNumberValidator extends CardNumberValidator{
    private String invalidNo;
    private String theftNo;

    // setInvalidNo로 지정된 카드 번호에 대해서는 invalid, 나머지는 valid
    public void setInvalidNo(String invalidNo){
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo){
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        // 유효하지 않은 카드 번호인 경우
        if(invalidNo != null && invalidNo.equals(cardNumber)){
            return CardValidity.INVALID;
        }

        // 도난 카드 번호인 경우
        if(theftNo != null && theftNo.equals(cardNumber)){
            return CardValidity.THEFT;
        }
        return CardValidity.VALID;
    }
}
