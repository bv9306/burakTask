package com.pinsoft.burakTask.exception;

import java.io.Serial;

public class MinesweeperValidationException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 2L;

  public MinesweeperValidationException(String message) {
    super(message);
  }
}
