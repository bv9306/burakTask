package com.pinsoft.burakTask.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the RpnCalculatorUtils class.
 */
public class RpnCalculatorUtilsTest {

  @Test
  void testIsValidRpnExpressionValidExpression() {
    String expression = "3 5 8 * 7 + *";
    assertTrue(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionInvalidExpressionNotEnoughOperands() {
    String expression = "5 +";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionInvalidExpressionInvalidCharacter() {
    String expression = "3 5 x +";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionEmptyExpression() {
    String expression = "";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }
}

