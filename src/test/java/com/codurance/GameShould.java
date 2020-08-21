package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Square.*;
import static com.codurance.Status.*;
import static org.fest.assertions.api.Assertions.assertThat;


public class GameShould {

  @Test
  void wait_for_x_to_play_first() {
    Game game = new Game();
    assertThat(game.state()).isEqualTo(new GameState(PLAY, X));
  }

  @Test
  void wait_for_O_to_play_after_x() {
    Game game = play(TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(PLAY, O));
  }

  @Test
  void alternate_the_players() {
    Game game = play(TOP_LEFT, TOP_MIDDLE);
    assertThat(game.state()).isEqualTo(new GameState(PLAY, X));
  }

  @Test
  void not_permit_square_to_be_played_twice() {
    Game game = play(TOP_LEFT, TOP_MIDDLE, TOP_LEFT);
    assertThat(game.state()).isEqualTo(new GameState(SQUARE_ALREADY_PLAYED, X));
  }

  // x o x
  // x x o
  // o x o
  @Test
  void recognise_a_draw() {

    Game game = play(
            TOP_LEFT,
            TOP_MIDDLE,
            TOP_RIGHT,
            CENTRE_RIGHT,
            CENTRE_LEFT,
            BOTTOM_LEFT,
            CENTRE_MIDDLE,
            BOTTOM_RIGHT,
            BOTTOM_MIDDLE
    );
    assertThat(game.state()).isEqualTo(new GameState(DRAW));
  }

  private Game play(Square... squares) {
    return Arrays.stream(squares)
            .reduce(new Game(), Game::play, (a, b) -> null);
  }
}

