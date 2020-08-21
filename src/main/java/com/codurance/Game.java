package com.codurance;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.START;

public class Game {

  private final Status status;
  private final Player nextUp;

  public Game() {
    status = START;
    nextUp = X;
  }

  public Game(Status status, Player nextUp) {
    this.status = status;
    this.nextUp = nextUp;
  }

  public GameState state() {

    return new GameState(START, nextUp);
  }

  public Game play() {
    return new Game(START, O);
  }
}
