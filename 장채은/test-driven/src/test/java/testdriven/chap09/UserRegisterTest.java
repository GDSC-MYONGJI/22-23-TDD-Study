package testdriven.chap09;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import testdriven.chap07.login.DupIdException;
import testdriven.chap07.login.MemoryUserRepository;
import testdriven.chap07.login.User;
import testdriven.chap07.login.UserRegister;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserRegisterTest {
    private UserRegister userRegister;
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    // 생략

    @Test
    void 이미_같은_ID_존재하면_가입_실패(){
        // 단위 테스트는 **대역**을 이용한 상황 구성
        fakeRepository.save(new User("id", "pw1", "email@email.com"));

        assertThrows(DupIdException.class, () ->{
            userRegister.register("id", "pw2", "email");
        });
    }
}
