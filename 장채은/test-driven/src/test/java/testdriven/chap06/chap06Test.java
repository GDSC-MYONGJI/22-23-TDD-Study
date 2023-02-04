package testdriven.chap06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class chap06Test {
    @Test
    void exactMatch(){
        BaseballGame game = new BaseballGame("456");

        Score score = game.guess("456");
        assertEquals(3, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void noMatch(){
        BaseballGame game = new BaseballGame("123");
        Score score = game.guess("456");

        assertEquals(0, score.strikes());
        assertEquals(0, score.balls());
    }
}
