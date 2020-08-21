package com.codurance;

import org.junit.jupiter.api.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class GameShould {
  private Game game = new Game();

  @Test
  void wait_for_x_to_play_first() {
    assertThat(game.state()).isEqualTo(new GameState(Status.START, Player.X));
  }
}
