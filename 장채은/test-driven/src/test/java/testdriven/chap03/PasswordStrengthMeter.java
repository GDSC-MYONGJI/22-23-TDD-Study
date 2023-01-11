package testdriven.chap03;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){
//        if("ab12!@A".equals(s) || "Ab12!c".equals(s)) return PasswordStrength.NORMAL;
        if(s.length()<8) return PasswordStrength.NORMAL;
        else return PasswordStrength.STRONG;
    }

}
