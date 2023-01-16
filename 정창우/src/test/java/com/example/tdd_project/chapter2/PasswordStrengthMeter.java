package com.example.tdd_project.chapter2;

import static com.example.tdd_project.chapter2.PasswordStrength.*;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String word){
        if (word == null || word.isEmpty()) return INVALID;
        int meetCount = getMeetCriteriaCount(word);

        if (meetCount <= 1) return WEAK;
        if (meetCount == 2) return NORMAL;
        return STRONG;
    }

    private int getMeetCriteriaCount(String word) {
        int meetCount = 0;
        if (word.length() >= 8) meetCount++;
        if (meetsContainingNumberCriteria(word)) meetCount++;
        if (meetsContainingUppercaseCriteria(word)) meetCount++;
        return meetCount;
    }

    private boolean meetsContainingUppercaseCriteria(String word) {
        for (char wo : word.toCharArray()){
            if (Character.isUpperCase(wo)){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String word){
        for (char wo : word.toCharArray()) {
            if (wo >= '0' && wo <= '9') {
                return true;
            }
        }
        return false;
    }
}
