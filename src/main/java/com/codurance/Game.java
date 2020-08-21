package com.codurance;

import static com.codurance.Player.X;
import static com.codurance.Status.START;

public class Game {
  public GameState state() {
    return new GameState(START, X);
  }
}
