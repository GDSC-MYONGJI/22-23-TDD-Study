package testdriven.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = getMetCriteriaCounts(s); // extract method -> 가독성을 위해

        // 개별 규칙을 검사하는 로직 + 규칙을 검사한 결과에 따라 암호 강도를 계산하는 로직
        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch:s.toCharArray()){
            if(ch>='0' && ch<='9'){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s){
        for(char ch:s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }


}
