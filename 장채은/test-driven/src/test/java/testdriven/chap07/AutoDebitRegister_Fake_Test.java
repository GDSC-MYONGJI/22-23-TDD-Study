package testdriven.chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdriven.chap07.CardValidity.INVALID;
import static testdriven.chap07.CardValidity.THEFT;

public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;
    private MemoryAutoDebitRepository repository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        this.repository = new MemoryAutoDebitRepository(); // 대역 객체
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    // 이미 정보가 저장되어 있는 경우
    @Test
    void alreadyRegistered_InfoUpdated() {
        repository.save(
                new AutoDebitInfo("user1", "1111222233334444", LocalDateTime.now()); // 이미 있는 사용자를 생성하기 위해 정보 저장
        );

        AutoDebitReq req = new AutoDebitReq("user1", "123456789012"); // user1 아이디에 대해 다른 카드 정보를 등록
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1"); // 대역에 보관된 자동이체 정보를 구함
        assertEquals("123456789012", saved.getCardNumber()); // 자동이체 정보와 같은지 확인
    }


    /**
     * @BeforeEach에 새로운 저장소를 생성했으므로,
     * 대역 DB는 초기화된 상태이다.
     */
    // 정보가 저장되어 있지 않은 경우
    @Test
    void notYetRegistered_newInfoRegistered() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234"); // user1 아이디에 대해 다른 카드 정보를 등록
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1"); // 대역에 보관된 자동이체 정보를 구함
        assertEquals("1234123412341234", saved.getCardNumber()); // 자동이체 정보와 같은지 확인
    }
}
