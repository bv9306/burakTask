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
    String errorMessage = "Invalid Minesweeper input.";
    MinesweeperValidationException exception = new MinesweeperValidationException(errorMessage);
    WebRequest request = null; // Mock or create a WebRequest as needed

    ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleValidationException(exception, request);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(400, body.get("status"));
    assertEquals("Bad Request", body.get("error"));
    assertEquals(errorMessage, body.get("message"));
  }

  @Test
  void testHandleRpnValidationException() {
    String errorMessage = "Invalid RPN expression.";
    RpnValidationException exception = new RpnValidationException(errorMessage);
    WebRequest request = null; // Mock or create a WebRequest as needed

    ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleValidationException(exception, request);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(400, body.get("status"));
    assertEquals("Bad Request", body.get("error"));
    assertEquals(errorMessage, body.get("message"));
  }

  @Test
  void testHandleGenericException() {
    Exception exception = new Exception("Something went wrong.");
    WebRequest request = null;

    ResponseEntity<Map<String, Object>> response = globalExceptionHandler.handleGenericException(exception, request);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    Map<String, Object> body = response.getBody();
    assertNotNull(body);
    assertEquals(500, body.get("status"));
    assertEquals("Internal Server Error", body.get("error"));
    assertEquals("An error occurred: Something went wrong.", body.get("message"));
  }
}

