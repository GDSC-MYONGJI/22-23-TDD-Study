package testdriven.chap05;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(("@DisplayName 테스트"))
public class DisplayNameTest {
    @DisplayName("값이 같은지 비교")
    @Test
    void assertEqualsMethod(){

    }

    @DisplayName("익셉션 발생 여부 테스트") // 테스트 메모
    @Test
    void assertThrowsTest(){

    }

    @Disabled // 특정 테스트 실행하고 싶지 않을 때
    @Test
    void failMethod(){

    }
}
