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


<br/>

```java
public class Calculator {
    public static int plus(int a1, int a2) {
        return 0;
    }
}
```

<br/>
<br/>

#### 테스트 결과

```shell
org.opentest4j.AssertionFailedError: 
Expected :3
Actual   :0
<Click to see difference>

	at com.example.chap2.CalculatorTest.plus(CalculatorTest.java:12)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)


Process finished with exit code -1
```