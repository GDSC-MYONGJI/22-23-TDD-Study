package testdriven.chap07;

public class StubCardNumberValidator extends CardNumberValidator{
    private String invalidNo;

    // setInvalidNo로 지정된 카드 번호에 대해서는 invalid, 나머지는 valid
    public void setInvalidNo(String invalidNo){
        this.invalidNo = invalidNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if(invalidNo != null && invalidNo.equals(cardNumber)){
            return CardValidity.INVALID;
        }
        return CardValidity.VALID;
    }
}
