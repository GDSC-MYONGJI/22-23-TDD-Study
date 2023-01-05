package com.hou27.chap02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
  private PasswordStrengthMeter meter = new PasswordStrengthMeter();

  private void assertStrength(String password, PasswordStrength expStr) {
    PasswordStrength result = meter.meter(password);
    assertEquals(expStr, result);
  }

  @Test
  void meetsAllCriteria_Then_Strong() {
    assertStrength("123ABCDE456", PasswordStrength.STRONG);
  }

  @Test
  void meetsOtherCriteria_except_for_Length_Then_Normal() {
    assertStrength("12345A", PasswordStrength.NORMAL);
  }

  @Test
  void meetsOtherCriteria_except_for_Number_Then_Normal() {
    assertStrength("ABCDEexceptNumber", PasswordStrength.NORMAL);
  }

  @Test
  void nullInput_Then_Invalid() {
    assertStrength(null, PasswordStrength.INVALID);
  }

}
