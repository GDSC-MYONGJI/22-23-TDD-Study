package testdriven.chap07.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository);
    }

    @DisplayName("약한 암호면 실패")
    @Test
    void weakPassword(){
        stubWeakPasswordChecker.setWeak(true); // 암호가 약하도록 응답

        assertThrows(WeakPasswordException.class, () ->
                userRegister.register("id", "pw", "email"));
    }

    @DisplayName("이미 같은 아이디가 존재하면 가입 실패")
    void dupIdExists(){
        // 이미 같은 아이디가 있는 상황으로 만들기
        fakeRepository.save(new User("id", "pw1", "email"));
        assertThrows(DupIdException.class,
                () -> userRegister.register("id", "pw2", "email"));
    }

    @DisplayName("같은 ID가 없으면 가입 성공함")
    void noDupId_RegisterSuccess(){
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }
}
