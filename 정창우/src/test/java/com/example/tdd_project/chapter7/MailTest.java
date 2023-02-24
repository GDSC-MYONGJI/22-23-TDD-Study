package com.example.tdd_project.chapter7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class MailTest {
    //생략
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@domain.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@domain.com", spyEmailNotifier.getEmail());
    }

    // 생략
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@domain.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@domain.com", realEmail);
    }

    // 생략
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRepository = new UserRegister(spyEmailNotifier);
    }

    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@domain.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@domain.com", spyEmailNotifier.getEmail());
    }


}
