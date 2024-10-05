package com.pinsoft.burakTask.service;

import com.pinsoft.burakTask.model.MinesweeperRequest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MinesweeperService class.
 * @author Burak
 */
public class MinesweeperServiceTest {

  private final MinesweeperService minesweeperService = new MinesweeperService();

  @Test
  void testGenerateHintsValidGrid() {
    final String[] grid = {"**...", ".....", ".*..."};
    final String[] expectedHints = {"**100", "33200", "1*100"};
    final MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    final String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }

  @Test
  void testGenerateHintsEmptyGrid() {
    final String[] grid = {".....", ".....", "....."};
    final String[] expectedHints = {"00000", "00000", "00000"};
    final MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    final String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }

  @Test
  void testGenerateHintsAllMines() {
    final String[] grid = {"*****", "*****", "*****"};
    final String[] expectedHints = {"*****", "*****", "*****"};
    final MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    final String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }
}

