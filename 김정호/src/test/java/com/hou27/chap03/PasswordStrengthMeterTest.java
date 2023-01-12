package com.hou27.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hou27.chap03.PasswordStrength;
import com.hou27.chap03.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
  @Test
  void meetsOnlyUpperCriteria_Then_Weak() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ABCDE");
    assertEquals(PasswordStrength.WEAK, result);
  }

  @Test
  void meetsAllCriteria_Then_Strong() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("123ABCDE456");
    assertEquals(PasswordStrength.STRONG, result);
  }

}
