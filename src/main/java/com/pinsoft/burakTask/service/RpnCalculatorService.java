package com.pinsoft.burakTask.service;

import com.pinsoft.burakTask.exception.MinesweeperValidationException;
import com.pinsoft.burakTask.exception.RpnValidationException;
import com.pinsoft.burakTask.model.RpnCalculatorRequest;
import com.pinsoft.burakTask.utils.RpnCalculatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * Service class for the Reverse Polish Notation (RPN) calculator.
 *
 * @author Burak
 */
@Slf4j
@Service
public class RpnCalculatorService {

  public double evaluateRPN(final RpnCalculatorRequest rpnCalculatorRequest) {

    final String expression = rpnCalculatorRequest.getExpression();

    if (!RpnCalculatorUtils.isValidRpnExpression(expression)) {
      throw new RpnValidationException("Invalid RPN expression format.");
    }

    Stack<Double> stack = new Stack<>();
    final String[] tokens = expression.split("\\s+");

    for (String token : tokens) {
      if (isOperator(token)) {
        double num2 = stack.pop();
        double num1 = stack.pop();
        double result = applyOperation(token, num1, num2);
        stack.push(result);
      } else {
        stack.push(Double.parseDouble(token));
      }
    }
    log.info("RPN expression evaluated successfully, result: {}", stack.peek());
    return stack.pop();
  }

  private boolean isOperator(final String token) {
    return "+-*/".contains(token);
  }

  private double applyOperation(final String operator, final double num1, final double num2) {
    log.info("Applying the operator: {} to the numbers: {} and {}", operator, num1, num2);
    return switch (operator) {
      case "+" -> num1 + num2;
      case "-" -> num1 - num2;
      case "*" -> num1 * num2;
      case "/" -> num1 / num2;
      default -> throw new MinesweeperValidationException("Invalid operator: " + operator);
    };
  }
}

