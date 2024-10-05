package com.pinsoft.burakTask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Unit test for RPN Calculator controller
 * @author Burak
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RpnCalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testEvaluateValidExpression() throws Exception {
    String validRpnJson = "{\"expression\": \"3 5 8 * 7 + *\"}";

    mockMvc.perform(post("/api/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(validRpnJson))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value(141.0));
  }

  @Test
  void testEvaluateInvalidExpression() throws Exception {
    String invalidRpnJson = "{\"expression\": \"5 +\"}";

    mockMvc.perform(post("/api/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidRpnJson))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid RPN expression format."));
  }
}

