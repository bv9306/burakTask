package com.pinsoft.burakTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Generic exception handler.
 * @author Burak
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({MinesweeperValidationException.class, RpnValidationException.class})
  public ResponseEntity<Map<String, Object>> handleValidationException(RuntimeException ex, WebRequest request) {
    Map<String, Object> errorDetails = new HashMap<>();
    errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
    errorDetails.put("error", "Bad Request");
    errorDetails.put("message", ex.getMessage());
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex, WebRequest request) {
    Map<String, Object> errorDetails = new HashMap<>();
    errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    errorDetails.put("error", "Internal Server Error");
    errorDetails.put("message", "An error occurred: " + ex.getMessage());
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}


