package com.hou27.chap02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

  @Test
  void plus() {
    assertEquals(2, Calculator.plus(1, 1)); // 현재 정적 메서드로 설계함.
  }
  
}
