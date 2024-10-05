package com.pinsoft.burakTask.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the RpnCalculatorUtils class.
 */
public class RpnCalculatorUtilsTest {

  @Test
  void testIsValidRpnExpressionValidExpression() {
    final String expression = "3 5 8 * 7 + *";
    assertTrue(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionInvalidExpressionNotEnoughOperands() {
    final String expression = "5 +";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionInvalidExpressionInvalidCharacter() {
    final String expression = "3 5 x +";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }

  @Test
  void testIsValidRpnExpressionEmptyExpression() {
    final String expression = "";
    assertFalse(RpnCalculatorUtils.isValidRpnExpression(expression));
  }
}

