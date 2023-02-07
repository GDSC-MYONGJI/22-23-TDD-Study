package com.hou27.chap07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegisterTest {
  private AutoDebitRegister register;

  @BeforeEach
  void setUp() {
    CardNumberValidator validator = new CardNumberValidator();
    AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
    register = new AutoDebitRegister(validator, repository);
  }

  @Test
  void validCard() {
    // 업체에서 받은 테스트용 유효한 카드번호 사용
    AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
    RegisterResult result = register.register(req);

    // 검증
    assertEquals(CardValidity.VALID, result.getValidity());
  }

  @Test
  void theftCard() {
    // 업체에서 받은 도난 테스트용 카드번호
    AutoDebitReq req = new AutoDebitReq("user1", "1234123412341235");
    RegisterResult result = register.register(req);

    // 검증
    assertEquals(CardValidity.THEFT, result.getValidity());
  }
}
