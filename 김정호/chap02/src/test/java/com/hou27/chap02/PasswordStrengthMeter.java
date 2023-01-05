package com.hou27.chap02;

public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if (s == null || s.isBlank()) {
      return PasswordStrength.INVALID;
    }
    int flagCnt = 0;
    if (s.length() >= 8) {
      flagCnt++;
    }
    if (s.matches(".*[0-9].*")) {
      flagCnt++;
    }
    if (s.matches(".*[A-Z].*")) {
      flagCnt++;
    }

    if (flagCnt == 1) {
      return PasswordStrength.WEAK;
    } else if (flagCnt == 3) {
      return PasswordStrength.STRONG;
    } else {
      return PasswordStrength.NORMAL;
    }
  }

}
