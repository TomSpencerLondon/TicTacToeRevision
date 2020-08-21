package com.codurance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.codurance.Square.*;

public class Board {
  private Set<Square> takenSquares;

  public Board(){
    this.takenSquares = Collections.emptySet();
  }

  private Board(Set<Square> takenSquares) {
    this.takenSquares = takenSquares;
  }

  public boolean alreadyTaken(Square square) {
    return takenSquares.contains(square);
  }

  public Board take(Square square) {
    Set<Square> newBoard = new HashSet<>(takenSquares);
    newBoard.add(square);
    return new Board(newBoard);
  }

  public boolean isFull() {
    return takenSquares.size() == 9;
  }

  public boolean hasWinningCombination() {
    Stream<Square> winningCombination = Stream.of(TOP_LEFT, CENTRE_LEFT, BOTTOM_LEFT);
    return winningCombination.allMatch(square -> takenSquares.contains(square));
  }
}
