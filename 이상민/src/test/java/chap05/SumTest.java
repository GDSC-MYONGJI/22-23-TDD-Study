package chap05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    void sum(){
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
