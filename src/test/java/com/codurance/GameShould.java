package com.codurance;

import org.junit.jupiter.api.Test;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.SQUARE_ALREADY_PLAYED;
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
    game = game.play(Square.TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(START, O));
  }

  @Test
  void alternate_the_players() {
    Game game = new Game();
    game = game.play(Square.TOP_LEFT);
    game = game.play(Square.TOP_MIDDLE);
    assertThat(game.state()).isEqualTo(new GameState(START, X));
  }

  @Test
  void not_permit_square_to_be_played_twice() {
    Game game = new Game();
    game = game.play(Square.TOP_LEFT);
    game = game.play(Square.TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(SQUARE_ALREADY_PLAYED, O));
  }
}
