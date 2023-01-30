package testdriven.chap05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethod {
    @Test
    void assertEqualsMethod(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.now();
        assertEquals(localDate, localDate1);
    }

    @Test
    void assertEqualsMethod2(){
        assertEquals(3, 5/2); // 에러 발생시, 검증 코드 실패로
        assertEquals(4, 2*2); // 이 코드 실행 되지 않음
    }

//    @Test
//    void failMethod(){
//        try{
//            AuthService authService = new AuthService();
//            authService.authenticate(null, null); // null 이 발생했는데, 익셉션이 발생하지 않으면 테스트 실패 (null == null)
//            fail();
//        }catch (IllegalArgumentException e){
//
//        }
//    }
//
//    @Test
//    void assertThrowsMethod(){
//        IllegalArgumentException e = assertThrows(IllegalStateException.class,
//                ()->{
//                    AuthService authService = new AuthService();
//                    authService.authenticate(null, null);
//                });
//
//        assertTrue(e.getMessage().contains("id"));
//    }

    @Test
    void assertAllMethod(){
        assertAll(
                () -> assertEquals(3, 5/2),
                () -> assertEquals(4, 2*2),
                () -> assertEquals(6, 11/2)
        );
    }
}
