package com.codurance;

import org.junit.jupiter.api.Test;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.START;
import static org.fest.assertions.api.Assertions.assertThat;


public class GameShould {
  private Game game = new Game();

  @Test
  void wait_for_x_to_play_first() {
    assertThat(game.state()).isEqualTo(new GameState(START, X));
  }

  @Test
  void wait_for_O_to_play_after_x() {
    Game game = new Game();
    game = game.play();
    assertThat(game.state()).isEqualTo(new GameState(START, O));
  }

  @Test
  void alternate_the_players() {
    Game game = new Game();
    game = game.play();
    game = game.play();
    assertThat(game.state()).isEqualTo(new GameState(START, X));
  }
}
