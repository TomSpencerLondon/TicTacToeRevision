package com.codurance;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class GameState {
  private final Status status;
  private final Player nextUp;

  public GameState(Status status, Player nextUp) {
    this.status = status;
    this.nextUp = nextUp;
  }

  @Override
  public boolean equals(Object o) {
    return reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return "Status: " + status + ", next up: " + nextUp;
  }
}
