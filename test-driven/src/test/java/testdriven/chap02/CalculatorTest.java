package testdriven.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 기능을 완성하면 test package -> main package로 이동
 * 완성되지 않은 코드가 배포되는 것을 막기 위함
  */

public class CalculatorTest {

    @Test
    void plus(){
        int result = Calculator.plus(1, 2);
        assertEquals(3, result); // 실제 값과 동일 한지 비교
        assertEquals(5, Calculator.plus(4, 1));
    }
}
