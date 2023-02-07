package com.hou27.chap07.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegisterTest {

  private UserRegister userRegister;
  private StubWeakPasswordChecker stubWeakPasswordChecker
      = new StubWeakPasswordChecker();
  private SpyEmailNotifier spyEmailNotifier
      = new SpyEmailNotifier();
  private MemoryUserRepository fakeRepository
      = new MemoryUserRepository();

  @BeforeEach
  void setUp() {
    userRegister = new UserRegister(
        stubWeakPasswordChecker,
        spyEmailNotifier,
        fakeRepository
    );
  }

  @Test
  @DisplayName("가입 시 메일 전송")
  void whenRegister_thenSendMail() {
    userRegister.register("id", "pw", "email@mail.com");

    assertTrue(spyEmailNotifier.isCalled());
    assertEquals("email@mail.com", spyEmailNotifier.getEmail());
  }
}
