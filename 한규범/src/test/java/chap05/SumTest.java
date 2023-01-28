package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {

    @Test
    public void sum(){
        int result = 2 + 3;
        assertEquals(5,result);

        assertAll(
                () -> assertEquals(3,5/2),
                () -> assertEquals(4,2*2),
                () -> assertEquals(6,11/2)
        );
     }



}
