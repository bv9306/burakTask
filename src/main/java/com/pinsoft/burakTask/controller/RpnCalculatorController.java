package com.pinsoft.burakTask.controller;

import com.pinsoft.burakTask.model.RpnCalculatorRequest;
import com.pinsoft.burakTask.model.RpnCalculatorResponse;
import com.pinsoft.burakTask.service.RpnCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for RPN Calculatoır.
 *
 * @author Burak
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RpnCalculatorController {
  @Autowired
  private RpnCalculatorService rpnCalculatorService;

  @PostMapping("/calculate")
  public ResponseEntity<RpnCalculatorResponse> calculate(@RequestBody RpnCalculatorRequest request) {
    log.info("Received a request to evaluate the RPN expression");
    final double result = rpnCalculatorService.evaluateRPN(request);
    return ResponseEntity.ok(RpnCalculatorResponse.builder().result(result).build());
  }
}
