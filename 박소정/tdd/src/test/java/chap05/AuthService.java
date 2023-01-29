package chap05;

public class AuthService {
    public void authenticate(String id, String pw) {
        if(id == null) throw new IllegalArgumentException("Null id");
        if(pw == null) throw new IllegalArgumentException("Null pw");
    }
}
