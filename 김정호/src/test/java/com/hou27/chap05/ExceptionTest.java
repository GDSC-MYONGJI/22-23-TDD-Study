package com.hou27.chap05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
  @Test
  void exceptionBasicTest() {
    assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException();
    });
  }

  @Test
  void exceptionMessageTest() {
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("message");
    });

    assertEquals("message", thrown.getMessage());
  }

}
