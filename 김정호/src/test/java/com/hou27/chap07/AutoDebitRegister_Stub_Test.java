package com.hou27.chap07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegister_Stub_Test {
  private AutoDebitRegister register;
  private StubCardNumberValidator stubValidator;
  private AutoDebitInfoRepository repository;

  @BeforeEach
  void setUp() {
    stubValidator = new StubCardNumberValidator();
    repository = new JpaAutoDebitInfoRepository();
    register = new AutoDebitRegister(stubValidator, repository);
  }

  @Test
  void invalidCard() {
    stubValidator.setInvalidNo("1234123412341234");

    // 설정한 유효하지 않은 카드번호 사용
    AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
    RegisterResult result = register.register(req);

    // 검증
    assertEquals(CardValidity.INVALID, result.getValidity());
  }

  @Test
  void theftCard() {
    stubValidator.setTheftNo("1234123412341235");

    // 설정한 도난당한 카드번호 사용
    AutoDebitReq req = new AutoDebitReq("user1", "1234123412341235");
    RegisterResult result = register.register(req);

    // 검증
    assertEquals(CardValidity.THEFT, result.getValidity());
  }
}
