package com.codurance;


import static com.codurance.Player.O;
import static com.codurance.Player.X;
import static com.codurance.Status.*;

public class Game {

  private final Status status;
  private final Player lastPlayer;
  private final Board board;

  public Game() {
    status = PLAY;
    lastPlayer = null;
    board = new Board();
  }

  public Game(Status status, Player lastPlayer, Board board) {
    this.lastPlayer = lastPlayer;
    this.board = board;

    if (board.isFull())
      this.status = DRAW;
    else if (board.hasWinningCombination(lastPlayer))
      this.status = lastPlayer == X ? X_HAS_WON : O_HAS_WON;
    else
      this.status = status;
  }

  public GameState state() {
    if (status == DRAW || status == X_HAS_WON || status == O_HAS_WON)
      return new GameState(status);
    else
      return new GameState(status, nextPlayer());
  }

  public Game play(Square square) {
    if (gameIsOver())
      return this;
    if (board.alreadyTaken(square))
      return new Game(SQUARE_ALREADY_PLAYED, lastPlayer, board);
    else
      return new Game(PLAY, nextPlayer(), board.take(square, nextPlayer()));
  }

  private boolean gameIsOver() {
    return status == DRAW || status == X_HAS_WON || status == O_HAS_WON;
  }

  private Player nextPlayer() {
    if (lastPlayer == null)
      return X;
    else
      return lastPlayer == X ? O : X;
  }
}
