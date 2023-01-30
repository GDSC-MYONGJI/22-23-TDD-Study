package study.tdd.chap04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("@DisplayName 테스트")
public class DisplayNameTest {

    @DisplayName("값 같은지 비교")
    @Test
    void assertEqualsMethod() {
        System.out.println("assertEqualsMethod");
    }

    @Disabled
    @Test
    void failMethod() {
        System.out.println("failMethod");
    }

    @DisplayName("익셉션 발생 여부 테스트")
    @Test
    void assertThrowsTest() {
        System.out.println("assertThrowsTest");
    }

    @Test
    void assertAllTest() {
        System.out.println("assertAllTest");
    }
}
