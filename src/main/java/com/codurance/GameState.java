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

  public GameState(Status status) {
    this.status = status;
    nextUp = null;
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

    return nextUp == null ?
            "Status: " + status :
            "Status: " + status + ", next up: " + nextUp;
  }
}
