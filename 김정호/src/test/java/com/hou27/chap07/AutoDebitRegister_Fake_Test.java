package com.hou27.chap07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegister_Fake_Test {
  private AutoDebitRegister register;
  private StubCardNumberValidator stubValidator;
  private AutoDebitInfoRepository repository;

  @BeforeEach
  void setUp() {
    stubValidator = new StubCardNumberValidator();
    repository = new MemoryAutoDebitInfoRepository();
    register = new AutoDebitRegister(stubValidator, repository);
  }

  @Test
  void alreadyRegistered_InfoUpdated() {
    repository.save(new AutoDebitInfo("user1", "123412349876", LocalDateTime.now()));

    AutoDebitReq req = new AutoDebitReq("user1", "123412349999");
    RegisterResult result = register.register(req);

    AutoDebitInfo saved = repository.findOne("user1");
    assertEquals("1234123412341235", saved.getCardNumber());
  }

  @Test
  void notYetRegistered_newInfoRegistered() {
    AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
    RegisterResult result = register.register(req);

    AutoDebitInfo saved = repository.findOne("user1");
    assertEquals("1234123412341234", saved.getCardNumber());
  }
}
