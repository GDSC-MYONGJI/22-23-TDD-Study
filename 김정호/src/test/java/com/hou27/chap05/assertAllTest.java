package com.hou27.chap05;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class assertAllTest {
  @Test
  void assertTest() {
    assertEquals(3, 8 / 3); // 검증 실패로 에러 발생
    assertEquals(3, 6 / 2); // 위 코드에서 에러 발생으로 이 코드는 실행되지 않음
    assertEquals(3, 8 / 2);
  }

  @Test
  void assertAllTest() {
    assertAll(
        () -> assertEquals(3, 8 / 3),
        () -> assertEquals(3, 6 / 2),
        () -> assertEquals(3, 8 / 2) // assertAll은 모든 검증을 실행함
    );
  }
}
