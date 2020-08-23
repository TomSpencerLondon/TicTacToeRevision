package com.codurance;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codurance.Square.*;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

public class Board {
  private Map<Square, Player> takenSquares;

  public Board(){

    this.takenSquares = Collections.emptyMap();
  }

  private Board(Map<Square, Player> takenSquares) {

    this.takenSquares = takenSquares;
  }

  public boolean alreadyTaken(Square square) {

    return takenSquares.keySet().contains(square);
  }

  public Board take(Square square, Player player) {
    Map<Square, Player> newBoard = new HashMap<>(takenSquares);
    newBoard.put(square, player);
    return new Board(newBoard);
  }

  public boolean isFull() {
    return takenSquares.size() == 9;
  }

  public boolean hasWinningCombination(Player player) {
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
            winningCombination.allMatch(squaresTakenBy(player)::contains));
  }

  private Set<Square> squaresTakenBy(Player player) {
    return takenSquares.entrySet().stream()
            .filter(entry -> entry.getValue() == player)
            .map(entry -> entry.getKey())
            .collect(toSet());
  }
}
