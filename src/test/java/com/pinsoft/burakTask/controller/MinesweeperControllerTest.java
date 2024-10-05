package com.pinsoft.burakTask.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pinsoft.burakTask.exception.MinesweeperValidationException;
import com.pinsoft.burakTask.model.MinesweeperRequest;
import com.pinsoft.burakTask.service.MinesweeperService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

/**
 * Unit test for Minesweeper controller
 * @author Burak
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MinesweeperControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private MinesweeperService minesweeperService;

  @InjectMocks
  private MinesweeperController minesweeperController;

  @Test
  void testShowHintsValidRequest() throws Exception {
    final MinesweeperRequest validRequest = new MinesweeperRequest();
    validRequest.setSquare(Arrays.asList("*.*", ".*.", "*.*"));

    final String[] expectedHints = {"*3*", "3*3", "*3*"};
    when(minesweeperService.generateHints(validRequest)).thenReturn(expectedHints);

    mockMvc.perform(post("/api/show-hints")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"square\": [\"*.*\", \".*.\", \"*.*\"]}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.hints[0]").value("*3*"))
        .andExpect(jsonPath("$.hints[1]").value("3*3"))
        .andExpect(jsonPath("$.hints[2]").value("*3*"));
  }

  @Test
  void testShowHintsInvalidRequest() throws Exception {
    doThrow(new MinesweeperValidationException("Invalid Minesweeper input format. Only '*' and '.' are allowed."))
        .when(minesweeperService).generateHints(any(MinesweeperRequest.class));

    mockMvc.perform(post("/api/show-hints")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"square\": [\"*.*\", \"abc\", \"*.*\"]}"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid Minesweeper input format. Only '*' and '.' are allowed."));
  }

  @Test
  void testShowHintsEmptyGrid() throws Exception {
    doThrow(new MinesweeperValidationException("Invalid Minesweeper input format. Only '*' and '.' are allowed."))
        .when(minesweeperService).generateHints(any(MinesweeperRequest.class));

    mockMvc.perform(post("/api/show-hints")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"square\": []}")) // Empty grid
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid Minesweeper input format. Only '*' and '.' are allowed."));
  }
}
