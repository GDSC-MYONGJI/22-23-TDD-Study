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

}
