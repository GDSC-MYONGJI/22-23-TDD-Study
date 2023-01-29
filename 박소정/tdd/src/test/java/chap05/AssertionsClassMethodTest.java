package chap05;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsClassMethodTest {

    @Test
    void sumTest() {
        int result = 2+3;
        assertEquals(5, result);
    }

    @DisplayName("익셉션 발생 여부 테스트 - fail()")
    @Test
    void failTest() {
        try{
            AuthService authService = new AuthService();
            authService.authenticate(null, null);
            fail();
        } catch(IllegalArgumentException e) {
        }
    }

    @DisplayName("익셉션 발생 여부 테스트 - assertThrows()")
    @Test
    void assertThrowsTest() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    AuthService authService = new AuthService();
                    authService.authenticate(null, null);
                });
        assertTrue(thrown.getMessage().contains("id"));
    }

    // 모든 검증 실행 후 실패한 것 확인
    @Disabled
    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals(3, 5/2),
                () -> assertEquals(4, 2*2),
                () -> assertEquals(6, 11/2)
        );
    }





}
