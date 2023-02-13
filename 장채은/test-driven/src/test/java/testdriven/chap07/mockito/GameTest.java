package testdriven.chap07.mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class GameTest {
    @Test
    void init(){
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        then(genMock).should().generate(GameLevel.EASY); // then : 모의 객체를 전달 받음 should : 모의 객체의 메서드가 불려야 한다는 것을 설정
    }
}
