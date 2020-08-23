package com.codurance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.codurance.Square.*;
import static java.util.stream.Stream.of;

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
    Stream<Stream<Square>> winningCombinations = of(
            of(TOP_LEFT, CENTRE_LEFT, BOTTOM_LEFT),
            of(TOP_MIDDLE, CENTRE_MIDDLE, BOTTOM_MIDDLE),
            of(TOP_RIGHT, CENTRE_RIGHT, BOTTOM_RIGHT),
            of(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT),
            of(CENTRE_LEFT,CENTRE_MIDDLE,CENTRE_RIGHT),
            of(BOTTOM_LEFT,BOTTOM_MIDDLE,BOTTOM_RIGHT),
            of(TOP_LEFT,CENTRE_MIDDLE,BOTTOM_RIGHT),
            of(TOP_RIGHT,CENTRE_MIDDLE,BOTTOM_LEFT)
           );
    return winningCombinations.anyMatch(winningCombination ->
            winningCombination.allMatch(takenSquares::contains));
  }
}
