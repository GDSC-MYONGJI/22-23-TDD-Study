package com.hou27.chap06;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GivenWhenThenTest {
  @Test
  void baseballGameExactMatch() {
    // given
    BaseballGame game = new BaseballGame("456");

    // when
    Score score = game.guess("456");

    // then
    assertEqual(3, score.strikes());
    assertEqual(0, score.balls());
  }

}
