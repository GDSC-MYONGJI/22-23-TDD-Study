package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s==null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = getMetCriteriaCounts(s);

        if(metCounts<=2) return PasswordStrength.WEAK;
        if(metCounts==3) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private static int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length()>=8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
        if(meetsContainingSpecialCharacterCriteria(s)) metCounts++;
        return metCounts;
    }

    private static boolean meetsContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(ch>='0' && ch<='9') {
                return true;
            }
        }
        return false;
    }

    private static boolean meetsContainingSpecialCharacterCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if("[!@#$%^&*(),.?:{}|<>]".contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }


}
