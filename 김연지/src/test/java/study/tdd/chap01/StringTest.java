package study.tdd.chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    void substring() {
        String str = "abcde";
        assertEquals("cd", str.substring(2, 4));
    }
}
