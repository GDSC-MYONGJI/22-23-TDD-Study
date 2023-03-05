package testdriven.chap09;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import testdriven.chap07.login.DupIdException;
import testdriven.chap07.login.UserRegister;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
public class UserRegisterIntTest {

    private final UserRegister register;
    private final JdbcTemplate jdbcTemplate;

    @Test
    void 동일한_ID가_이미_존재하면_익셉션(){
        // 상황 insert 쿼리 실행
        jdbcTemplate.update(
                "insert into user values(?, ?, ?)" +
                        "on duplicate key update password = ?, email = ?",
                "cbk", "pw", "cbk@cbk.com", "pw", "cbk@cbk.com");

        // 실행 결과 확인
        assertThrows(DupIdException.class, () ->
                register.register("cbk", "strongpw", "email@email.com"));
    }

    @Test
    void 존재하지_않으면_저장함(){
        // 상황 delete 쿼리 실행
        jdbcTemplate.update("delete from user where id = ?", "cbk");

        // 실행
        register.register("cbk", "strongpw", "email@email.com");

        // 결과 확인 select 쿼리 진행
        SqlRowSet rs  = jdbcTemplate.queryForRowSet(
                "select * from user where id = ?", "cbk"
        );

        rs.next();
        assertEquals("email@email.com", rs.getString("email"));
    }

}
