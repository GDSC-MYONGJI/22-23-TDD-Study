package com.hou27.chap02;

public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if (s == null || s.isBlank()) {
      return PasswordStrength.INVALID;
    }

    int criteriaCnt = getCriteriaCnt(s);

    if (criteriaCnt == 2) {
      return PasswordStrength.NORMAL;
    } else if (criteriaCnt == 3) {
      return PasswordStrength.STRONG;
    } else {
      return PasswordStrength.WEAK;
    }
  }

  private int getCriteriaCnt(String s) {
    int criteriaCnt = 0;
    if (s.length() >= 8) {
      criteriaCnt++;
    }
    if (s.matches(".*[0-9].*")) {
      criteriaCnt++;
    }
    if (s.matches(".*[A-Z].*")) {
      criteriaCnt++;
    }
    return criteriaCnt;
  }

}
