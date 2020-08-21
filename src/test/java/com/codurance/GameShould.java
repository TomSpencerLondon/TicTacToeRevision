package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Square.TOP_LEFT;
import static com.codurance.Square.TOP_MIDDLE;
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
    Game game = play(TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(START, O));
  }

  @Test
  void alternate_the_players() {
    Game game = new Game();
    game = play(TOP_LEFT, TOP_MIDDLE);
    assertThat(game.state()).isEqualTo(new GameState(START, X));
  }

  @Test
  void not_permit_square_to_be_played_twice() {
    Game game = play(TOP_LEFT, TOP_MIDDLE, TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(SQUARE_ALREADY_PLAYED, X));
  }

  private Game play(Square... squares) {
    return Arrays.stream(squares)
            .reduce(new Game(), Game::play, (a, b) -> null);
  }
}

