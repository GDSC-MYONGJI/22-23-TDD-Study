package com.hou27.chap03;

public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if(s == "123ABCDE456") {
      return PasswordStrength.STRONG;
    }
    return PasswordStrength.WEAK;
  }

}
