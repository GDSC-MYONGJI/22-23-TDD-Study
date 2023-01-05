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
//    PasswordStrengthMeter meter = new PasswordStrengthMeter();
//    PasswordStrength result = meter.meter("123ABCDE456");
//    assertEquals(PasswordStrength.STRONG, result);
  }

  @Test
  void meetsOtherCriteria_except_for_Length_Then_Normal() {
    assertStrength("12345A", PasswordStrength.NORMAL);
//    PasswordStrengthMeter meter = new PasswordStrengthMeter();
//    PasswordStrength result = meter.meter("12345A");
//    assertEquals(PasswordStrength.NORMAL, result);
  }

  @Test
  void meetsOtherCriteria_except_for_Number_Then_Normal() {
    assertStrength("ABCDEexceptNumber", PasswordStrength.NORMAL);
//    PasswordStrengthMeter meter = new PasswordStrengthMeter();
//    PasswordStrength result = meter.meter("ABCDEexceptNumber");
//    assertEquals(PasswordStrength.NORMAL, result);
  }

}
