package testdriven.chap07.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameCenMockTest {

    @Test
    void mockTest(){
        GameNumGen genMock = mock(GameNumGen.class); // 모의 객체 생성 예
        given(genMock.generate(GameLevel.EASY)).willReturn("123"); // given: 모의 객체 매서드 호출을 전달

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num);
    }

    @Test
    void mockThrowTest(){
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);
//        given(genMock.generate(null)).willThrow(new IllegalArgumentException());

        assertThrows(
                IllegalArgumentException.class,
                () -> genMock.generate(null)
        );
    }

}
