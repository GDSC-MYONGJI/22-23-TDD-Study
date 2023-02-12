//package testdriven.chap07.validCard;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import testdriven.chap07.validCard.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static testdriven.chap07.validCard.CardValidity.THEFT;
//import static testdriven.chap07.validCard.CardValidity.VALID;
//
//public class AutoDebitRegisterTest {
//    private AutoDebitRegister register;
//
//    @BeforeEach
//    void setUp(){
//        CardNumberValidator validator = new CardNumberValidator();
//        AutoDebitInfoRepository repository = new JPAAutoDebitInfoRepository();
//        register = new AutoDebitRegister(validator, repository);
//    }
//
//    @Test
//    void validCard(){
//        // 외부 업체에서 받은 테스트용 유효한 카드번호 사용
//        // 대역을 사용하여 테스트 진행
//        AutoDebitReq req = new AutoDebitReq("user1", "123412341234");
//        RegisterResult result = this.register.register(req);
//        assertEquals(VALID, result.getValidity());
//    }
//
//    @Test
//    void theftCard(){
//        // 외부 업체에서 받은 도난 테스트용 카드 번호 사용
//        // 대역을 사용하여 테스트 진행
//        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
//        RegisterResult result = this.register.register(req);
//        assertEquals(THEFT, result.getValidity());
//    }
//}
