package com.codurance;


import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.SQUARE_ALREADY_PLAYED;
import static com.codurance.Status.START;

public class Game {

  private final Status status;
  private final Player lastPlayer;
  private final Board board;

  public Game() {
    status = START;
    lastPlayer = null;
    board = new Board();
  }

  public Game(Status status, Player lastPlayer, Board board) {
    this.status = status;
    this.lastPlayer = lastPlayer;
    this.board = board;
  }

  public GameState state() {
    return new GameState(status, nextPlayer());
  }

  public Game play(Square square) {
    if (board.alreadyTaken(square))
      return new Game(SQUARE_ALREADY_PLAYED, lastPlayer, board);
    else
      return new Game(START, nextPlayer(), board.take(square));
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
