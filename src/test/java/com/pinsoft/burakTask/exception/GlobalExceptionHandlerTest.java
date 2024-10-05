package com.pinsoft.burakTask.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Unit test for GlobalExceptionHandler class.
 * @author Burak
 */
@SuppressWarnings("PMD.TooManyAssertions")
public class GlobalExceptionHandlerTest {

  private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

  @Test
  void testHandleMinesweeperValidationException() {
    final String errorMessage = "Invalid Minesweeper input.";
    final MinesweeperValidationException exception = new MinesweeperValidationException(errorMessage);

    final ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleValidationException(exception);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(400, body.get("status"));
    assertEquals("Bad Request", body.get("error"));
    assertEquals(errorMessage, body.get("message"));
  }

  @Test
  void testHandleRpnValidationException() {
    final String errorMessage = "Invalid RPN expression.";
    final RpnValidationException exception = new RpnValidationException(errorMessage);

    final ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleValidationException(exception);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(400, body.get("status"));
    assertEquals("Bad Request", body.get("error"));
    assertEquals(errorMessage, body.get("message"));
  }

  @Test
  void testHandleGenericException() {
    final Exception exception = new Exception("Something went wrong.");

    final ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleGenericException(exception);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(500, body.get("status"));
    assertEquals("Internal Server Error", body.get("error"));
    assertEquals("An error occurred: Something went wrong.", body.get("message"));
  }
}

