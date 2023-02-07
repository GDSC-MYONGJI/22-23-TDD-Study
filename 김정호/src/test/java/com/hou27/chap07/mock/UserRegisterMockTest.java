package com.hou27.chap07.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegisterMockTest {

  private UserRegister userRegister;
  private WeakPasswordChecker mockPasswordChecker
      = Mockito.mock(WeakPasswordChecker.class);
  private EmailNotifier mockEmailNotifier
      = Mockito.mock(EmailNotifier.class);
  private UserRepository fakeRepository
      = new MemoryUserRepository();

  @BeforeEach
  void setUp() {
    userRegister = new UserRegister(
        mockPasswordChecker,
        mockEmailNotifier,
        fakeRepository
    );
  }

  @Test
  @DisplayName("약한 암호면 가입 실패")
  void whenWeakPassword_thenFailRegister() {
    BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw"))
        .willReturn(true);

    assertThrows(WeakPasswordException.class, () -> {
      userRegister.register("id", "pw", "email");
    });
  }

  @Test
  @DisplayName("회원 가입 시 암호 검사 수행")
  void whenRegister_thenCheckPassword() {
    userRegister.register("id", "pw", "email");

    BDDMockito.then(mockPasswordChecker)
        .should()
        .checkPasswordWeak("pw");
  }

  @Test
  @DisplayName("가입 시 메일 전송")
  void whenRegister_thenSendMail() {
    userRegister.register("id", "pw", "email@mail.com");

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    BDDMockito.then(mockEmailNotifier)
        .should()
        .sendRegisterEmail(captor.capture());

    String realEmail = captor.getValue();
    assertEquals("email@mail.com", realEmail);
  }
}
