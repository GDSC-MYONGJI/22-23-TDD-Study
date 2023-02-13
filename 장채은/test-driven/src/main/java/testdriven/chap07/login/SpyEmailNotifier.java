package testdriven.chap07.login;

public class SpyEmailNotifier implements EmailNotifier {

    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void sendRegisterEmail(String email) {
        this.called = true; // test 코드의 assert True 를 통과시키기 위함
        this.email = email;
    }
}
