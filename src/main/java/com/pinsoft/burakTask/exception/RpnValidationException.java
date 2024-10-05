package com.pinsoft.burakTask.exception;

import java.io.Serial;

public class RpnValidationException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1L;
  public RpnValidationException(String message) {
    super(message);
  }
}
