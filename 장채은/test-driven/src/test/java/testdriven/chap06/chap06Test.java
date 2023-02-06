package testdriven.chap06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class chap06Test {
    BaseballGame game;
    @BeforeEach // 상황 설정
    void giveenGame(){
        game = new BaseballGame("456");
    }

    @Test
    void exactMatch(){
        Score score = game.guess("456");
        assertEquals(3, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void noMatch(){
        Score score = game.guess("456");

        assertEquals(0, score.strikes());
        assertEquals(0, score.balls());
    }
}
