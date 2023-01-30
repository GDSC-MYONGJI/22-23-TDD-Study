package study.tdd.chap04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// 주요 단언 메서드
public class Methods {

    @Test
    void assertEquals_메서드() {
        LocalDate dateTime1 = LocalDate.now();
        LocalDate dateTime2 = LocalDate.now();
        assertEquals(dateTime1, dateTime2);
    }

    @Test
    void fail_메서드() {
        try {
            //AuthService authService = new AuthService();
            //authService.authenticate(null, null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void assertThrows_메서드() {
        assertThrows(IllegalArgumentException.class,
                () -> {
            //AuthService authService = new AuthService();
                    //authService.authenticate(null, null);
                });

        // assertThrows() 메서드는 발생한 익셉션 객체를 리턴한다.
        // 발생한 익셉션을 이용해서 추가로 검증
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    //AuthService authService = new AuthService();
                    //authService.authenticate(null, null);
                });
        assertTrue(thrown.getMessage().contains("id"));
    }

    @Test
    void assertAll_메서드() {
        assertEquals(3, 5/2);
        assertEquals(4, 2 * 2);

        assertAll(
                () -> assertEquals(3, 5/2),
                () -> assertEquals(4, 2 * 2),
                () -> assertEquals(6, 11 / 2)
        );

    }
}
