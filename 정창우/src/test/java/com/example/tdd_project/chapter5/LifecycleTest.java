package com.example.tdd_project.chapter5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Lifecycle 테스트")
@SpringBootTest
public class LifecycleTest {

    public LifecycleTest(){
        System.out.println("new Lifecycle Test");
    }

    @DisplayName("준비 작업")
    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @DisplayName("A 프린트 테스트")
    @Test
    void a() {
        System.out.println("A");
    }

    @DisplayName("미완성 테스트")
    @Disabled
    @Test
    void b() {
        System.out.println("B");
    }

    @DisplayName("마무리 작업")
    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

}
