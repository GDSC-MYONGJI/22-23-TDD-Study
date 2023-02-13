package testdriven.chap07.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class UserRegisterMockTest {
    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        // 암호가 약하도록(true) return 함
        given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true); // "pw" 인자를 사용하여 모의 객체의 checkPasswordWeak 메서드를 호출하면 결과를 true로 return 해라

        // 암호가 약해서 나타나는 에러처리가 같은 것인지 확인
        assertThrows(WeakPasswordException.class, () ->
                userRegister.register("id", "pw", "email"));
    }

    @DisplayName("회원 가입 시 암호 검사 수행함")
    @Test
    void checkPassword(){
        userRegister.register("id", "pw", "email");

        then(mockPasswordChecker)
                .should()
                .checkPasswordWeak(BDDMockito.anyString());
    }

    // spy: 진짜로 호출되었는지 확인
    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail(){
        userRegister.register("id", "pw", "email");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); // String 타입의 인자 보관
        then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email", realEmail);
    }

}
