package study.tdd.chap04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class sumTest {

    @Test
    void sum() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
