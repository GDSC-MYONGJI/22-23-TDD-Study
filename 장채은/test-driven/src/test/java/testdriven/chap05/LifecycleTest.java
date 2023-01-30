package testdriven.chap05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {
    public LifecycleTest(){
        System.out.println("new LifecycleTest");
    }

    // 각각 테스트 하나 진행 시작할 때 호출되는 메소드
    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @Test
    void a(){
        System.out.println("A");
    }

    @Test
    void b(){
        System.out.println("B");
    }

    // 각각 테스트 하나 진행 끝날 때 호출되는 메소드
    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }
}
