package com.pinsoft.burakTask.service;

import com.pinsoft.burakTask.exception.RpnValidationException;
import com.pinsoft.burakTask.model.RpnCalculatorRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RpnCalculatorService class.
 * @author Burak
 */
public class RpnCalculatorServiceTest {

  private final RpnCalculatorService rpnCalculatorService = new RpnCalculatorService();

  @Test
  void testEvaluateValidExpression() {
    String expression = "3 5 8 * 7 + *";
    RpnCalculatorRequest request = new RpnCalculatorRequest(expression);
    double result = rpnCalculatorService.evaluateRPN(request);
    assertEquals(141.0, result);
  }

  @Test
  void testEvaluateAdditionSimpleExpression() {
    String expression = "4 2 +";
    RpnCalculatorRequest request = new RpnCalculatorRequest(expression);
    double result = rpnCalculatorService.evaluateRPN(request);
    assertEquals(6.0, result);
  }

  @Test
  void testEvaluateSubtractionSimpleExpression() {
    String expression = "9 2 -";
    RpnCalculatorRequest request = new RpnCalculatorRequest(expression);
    double result = rpnCalculatorService.evaluateRPN(request);
    assertEquals(7.0, result);
  }

  @Test
  void testEvaluateDivisionSimpleExpression() {
    String expression = "10 2 /";
    RpnCalculatorRequest request = new RpnCalculatorRequest(expression);
    double result = rpnCalculatorService.evaluateRPN(request);
    assertEquals(5.0, result);
  }

  @Test
  void testEvaluateInvalidExpressionThrowsException() {
    String expression = "5 +";
    RpnCalculatorRequest request = new RpnCalculatorRequest(expression);
    assertThrows(RpnValidationException.class, () -> rpnCalculatorService.evaluateRPN(request));
  }
}

