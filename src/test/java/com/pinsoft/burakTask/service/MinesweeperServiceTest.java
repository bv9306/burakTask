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
    String[] grid = {"**...", ".....", ".*..."};
    String[] expectedHints = {"**100", "33200", "1*100"};
    MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }

  @Test
  void testGenerateHintsEmptyGrid() {
    String[] grid = {".....", ".....", "....."};
    String[] expectedHints = {"00000", "00000", "00000"};
    MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }

  @Test
  void testGenerateHintsAllMines() {
    String[] grid = {"*****", "*****", "*****"};
    String[] expectedHints = {"*****", "*****", "*****"};
    MinesweeperRequest request = new MinesweeperRequest(Arrays.asList(grid));

    String[] result = minesweeperService.generateHints(request);
    assertArrayEquals(expectedHints, result);
  }
}

