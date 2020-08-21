package com.codurance;

import static com.codurance.Player.X;
import static com.codurance.Status.GAME_ON;

public class Game {
  public GameState state() {
    return new GameState(GAME_ON, X);
  }
}
