package com.pinsoft.burakTask.utils;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the MinesweeperUtils class.
 * @author Burak
 */
public class MinesweeperUtilsTest {

  @Test
  void testValidMinesweeperGrid() {
    String[] grid = {"*...", ".*..", "...*", "...."};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGrid_InvalidCharacter() {
    String[] grid = {"*...", ".*..", "...*", "..a."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGrid_EmptyString() {
    String[] grid = {"*...", ".*..", "", "...."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testValidMinesweeperGrid_AllMines() {
    String[] grid = {"****", "****", "****", "****"};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testValidMinesweeperGrid_AllEmpty() {
    String[] grid = {"....", "....", "....", "...."};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGrid_MixedInvalidCharacters() {
    String[] grid = {"*..*", "..1.", ".*..", "...."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testEmptyMinesweeperGrid() {
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Collections.emptyList()));
  }

  @Test
  void testSingleRowValidGrid() {
    String[] grid = {"****"};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testSingleRowInvalidGrid() {
    String[] grid = {"**x*"};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }
}

