package com.codurance;

public class Board {
  private Square takenSquare;

  public Board(){
    this.takenSquare = null;
  }

  public Board(Square takenSquare) {
    this.takenSquare = takenSquare;
  }

  public boolean alreadyTaken(Square square) {
    return takenSquare == square;
  }

  public Board take(Square square) {
    return new Board(square);
  }
}
