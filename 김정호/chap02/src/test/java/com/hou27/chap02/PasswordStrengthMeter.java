package com.hou27.chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null || s.isBlank()) {
            return PasswordStrength.INVALID;
        }
        else if (s.length() < 8 || !s.matches(".*[0-9].*")) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

}
