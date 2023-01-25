package com.hou27.chap05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadTest {
  private int value = 0; // 테스트 메서드가 공유하는 인스턴스 변수

  @Test
  @DisplayName("value 값을 더하면 1이 증가한다.")
  void value_값을_더하면_1이_증가() {
    value += 1; // 테스트 메서드가 공유하는 인스턴스 변수를 사용함
    int prev = 3;
    int result = prev + value;

    assertEquals(prev+1, result);
  }

  @Test
  @DisplayName("value 값을 더하면 2가 증가한다.")
  void value_값을_더하면_2가_증가() {
    value += 2; // 테스트 메서드가 공유하는 인스턴스 변수를 사용함
    int prev = 3;
    int result = prev + value;

    assertEquals(prev+2, result);
  }


}
