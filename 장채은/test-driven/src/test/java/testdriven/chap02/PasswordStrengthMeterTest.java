package testdriven.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    // 리펙토링
    /**
     * 단, 테스트 코드 중복을 무턱대고 제거하면 안됨.
     * 중복을 제거한 후에도 가독성이 덜어지지 않고 수정이 용이한 경우에만 중복 제거
     */
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    ///

    // 빈 테스트 메소드를 실행하는 것 또한 나름대로 의미가 있음
    @Test
    void name(){
    }

    @Test // 모든 규칙을 충족하는 경우
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc!Add", PasswordStrength.STRONG);
    }
    /**
     * assertEquals: 두 값이 같은지 비교하는 단언
     * 단언: 값의 특정 조건이 충족하는지 확인하고 충족하지 않는 경우에 익셉션 발생 -> 테스트 실패
     */

    @Test // 길이만 8글자 미만이고 나머지 조건을 충족하는 경우
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test // 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    void meetOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test // 값이 없는 경우
    void nullInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test // 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test // 길이가 8글자 이상인 조건만 충족하는 경우
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abcdefghi", PasswordStrength.WEAK);
    }

    @Test // 숫자 포함 조건만 충족하는 경우 , 숫자만 있는 경우
    void meetsOnlyNumCriteria_Then_Week(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test // 대문자 포함 조건만 충족하는 경우
    void meetsOnlyUpperCriteria_Then_Week(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Week(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
