package testdriven.chap07.mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GameCenMockTest {

    @Test
    void mockTest(){
        GameNumGen getMock = mock(GameNumGen.class); // 모의 객체 생성 예
    }
}
