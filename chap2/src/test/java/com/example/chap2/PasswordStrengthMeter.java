package com.example.chap2;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNum = false;
        for(char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                containsNum = true;
                break;
            }
        }
        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
