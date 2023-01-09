package com.example.chap2;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCount = 0;

        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = meetsContainingUppercaseCriteria(s);

        if(lengthEnough) {
            metCount++;
        }
        if(containsNum) {
            metCount++;
        }
        if(containsUpp) {
            metCount++;
        }

        if(metCount <= 1) {
            return PasswordStrength.WEAK;
        }
        if(metCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }


    private static boolean meetsContainingUppercaseCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }


    private static boolean meetsContainingNumberCriteria(String s) {
        for(char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }


}
