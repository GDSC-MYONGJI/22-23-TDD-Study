package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID; // 값이 없는 경우
        int metCounts = getMetCriteriaCounts(s);
        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8) metCounts++; // 길이가 8글자 이상인 조건만 충족하는 경우
        if(meetsContainingNumberCriteria(s)) metCounts++; // 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
        if(meetsContainingUppercaseCriteria(s)) metCounts++;  // 대문자를 포함하지 않고 나머지 조건을 충족시킬 경우
        return metCounts;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <='9'){
                return true;
            }
        }
        return false;
    }
}
