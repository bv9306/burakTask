package com.pinsoft.burakTask.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * This class is responsible for checking if a given Minesweeper grid is valid.
 *
 * @author Burak
 */
@Slf4j
public final class MinesweeperUtils {
  private static final String MINESWEEPER_REGEX = "^[*.]+$";

  private static final Pattern MINESWEEPER_PATTERN = Pattern.compile(MINESWEEPER_REGEX);

  public static boolean isValidMinesweeperInput(List<String> grid) {
    log.info("Checking if the given Minesweeper grid is valid.");
    if (Objects.isNull(grid) || grid.isEmpty()) {
      log.error("The given Minesweeper grid is null or empty.");
      return false;
    }
    for (String row : grid) {
      if (!MINESWEEPER_PATTERN.matcher(row).matches()) {
        log.error("The given Minesweeper grid is invalid.");
        return false;
      }
    }
    log.info("The given Minesweeper grid is valid.");
    return true;
  }
}

