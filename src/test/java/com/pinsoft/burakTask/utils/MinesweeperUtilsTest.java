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
    final String[] grid = {"*...", ".*..", "...*", "...."};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGridInvalidCharacter() {
    final String[] grid = {"*...", ".*..", "...*", "..a."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGridEmptyString() {
    final String[] grid = {"*...", ".*..", "", "...."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testValidMinesweeperGridAllMines() {
    final String[] grid = {"****", "****", "****", "****"};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testValidMinesweeperGridAllEmpty() {
    final String[] grid = {"....", "....", "....", "...."};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testInvalidMinesweeperGridMixedInvalidCharacters() {
    final String[] grid = {"*..*", "..1.", ".*..", "...."};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testEmptyMinesweeperGrid() {
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Collections.emptyList()));
  }

  @Test
  void testSingleRowValidGrid() {
    final String[] grid = {"****"};
    assertTrue(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }

  @Test
  void testSingleRowInvalidGrid() {
    final String[] grid = {"**x*"};
    assertFalse(MinesweeperUtils.isValidMinesweeperInput(Arrays.asList(grid)));
  }
}

