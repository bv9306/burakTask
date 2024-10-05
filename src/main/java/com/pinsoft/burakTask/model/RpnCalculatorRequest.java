package com.pinsoft.burakTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpnCalculatorRequest {
  private String expression;
}
