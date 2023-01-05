package com.hou27.chap02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

  @Test
  void meetsAllCriteria_Then_Strong() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("123ABCDE456");
    assertEquals(PasswordStrength.STRONG, result);
  }

  @Test
  void meetsOtherCriteria_except_for_Length_Then_Normal() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("12345A");
    assertEquals(PasswordStrength.NORMAL, result);
  }

  @Test
  void meetsOtherCriteria_except_for_Number_Then_Normal() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ABCDEexceptNumber");
    assertEquals(PasswordStrength.NORMAL, result);
  }

}
