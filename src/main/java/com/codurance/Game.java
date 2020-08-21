package com.codurance;

import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.START;

public class Game {

  private final Status status;
  private final Player lastPlayer;

  public Game() {
    status = START;
    lastPlayer = null;
  }

  public Game(Status status, Player lastPlayer) {
    this.status = status;
    this.lastPlayer = lastPlayer;
  }

  public GameState state() {
    return new GameState(START, nextPlayer());
  }

  public Game play() {
    return new Game(START, nextPlayer());
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
