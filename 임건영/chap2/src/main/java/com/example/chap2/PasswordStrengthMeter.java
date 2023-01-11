package com.example.chap2;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCount = getMetCriteriaCounts(s);

        if(metCount <= 1) {
            return PasswordStrength.WEAK;
        }
        if(metCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
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
        return metCount;
    }


    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }


    private boolean meetsContainingNumberCriteria(String s) {
        for(char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }


}
