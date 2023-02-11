package testdriven.chap07;

public class RegisterResult {
    private CardValidity validity;
    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult();
    }

    public static RegisterResult success() {
        return new RegisterResult();
    }

    public CardValidity getValidity() {
        return null;
    }
}
