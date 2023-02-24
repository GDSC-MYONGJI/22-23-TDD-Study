package com.example.tdd_project.chapter7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserRepositoryMockOvercaseTest {
    private UserRegister userRegister;
    private UserRepository mockRepository = Mockito.mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockRepository);
    }

    @Test
    void registerSuccess() {
        userRegister.register("id", "pw", "email");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(User.class);
        BDDMockito.then(mockRepository).should().save(captor.capture());

        User savedUser = captor.getValue();
        assertEquals("id", savedUser.getId())
        assertEquals("email@domain.com", savedUser.getEmail());
    }

    @Test
    void register() {
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId())
        assertEquals("email", savedUser.getEmail());
    }
}
