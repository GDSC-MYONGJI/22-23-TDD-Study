```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void plus() {
        int result = Calculator.plus(1, 2);
        assertEquals(3, result);
    }
}
```

- `@Test`: JUnit5의 테스트 어노테이션
- `assertEquals`: JUnit5의 테스트 메소드, 첫 번째 인자가 두 번째 인자와 같은지 확인, 같지 않으면 테스트 실패 (AssertFailedError)