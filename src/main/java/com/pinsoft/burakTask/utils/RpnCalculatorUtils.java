package com.pinsoft.burakTask.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * This class is responsible for checking if a given RPN expression is valid.
 *
 * @author Burak
 */
@Slf4j
public class RpnCalculatorUtils {

  public static boolean isValidRpnExpression(String expression) {
    log.info("Checking if the given RPN expression is valid.");
    if (expression == null || expression.trim().isEmpty()) {
      log.error("The given RPN expression is null or empty.");
      return false;
    }

    String[] tokens = expression.split("\\s+");
    Stack<String> stack = new Stack<>();

    for (String token : tokens) {
      if (isNumber(token)) {
        stack.push(token);
      } else if (isOperator(token)) {
        // For each operator, we need at least two operands on the stack
        if (stack.size() < 2) {
          return false;
        }
        stack.pop();
        stack.pop();
        stack.push("result");
      } else {
        log.error("The given RPN expression is invalid because of invalid symbl.");
        return false;
      }
    }

    return stack.size() == 1;
  }

  private static boolean isNumber(String token) {
    try {
      Double.parseDouble(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isOperator(String token) {
    return "+-*/".contains(token);
  }
}


