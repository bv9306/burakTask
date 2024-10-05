package com.pinsoft.burakTask.service;

import com.pinsoft.burakTask.exception.MinesweeperValidationException;
import com.pinsoft.burakTask.model.MinesweeperRequest;
import com.pinsoft.burakTask.utils.MinesweeperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for the Minesweeper game.
 *
 * @author Burak
 */
@Slf4j
@Service
public class MinesweeperService {

  public String[] generateHints(MinesweeperRequest request) {
    List<String> grid = request.getSquare();

    if (!MinesweeperUtils.isValidMinesweeperInput(grid)) {
      log.error("Invalid Minesweeper input format. Only '*' and '.' are allowed.");
      throw new MinesweeperValidationException("Invalid Minesweeper input format. Only '*' and '.' are allowed.");
    }

    int rows = grid.size();
    int cols = grid.get(0).length();
    char[][] board = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      board[i] = grid.get(i).toCharArray();
    }

    char[][] result = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == '*') {
          result[i][j] = '*';
        } else {
          int mineCount = countAdjacentMines(board, i, j);
          result[i][j] = (char) (mineCount + '0');
        }
      }
    }

    String[] hints = new String[rows];
    for (int i = 0; i < rows; i++) {
      hints[i] = new String(result[i]);
    }
    log.info("Hints generated successfully");
    return hints;
  }

  // As a first collect all the mines to the brd and then count the adjacent mines
  private int countAdjacentMines(char[][] board, int row, int col) {
    log.info("Counting adjacent mines for the given cell.");
    int[] directions = {-1, 0, 1};
    int mineCount = 0;
    for (int dr : directions) {
      for (int dc : directions) {
        if (dr == 0 && dc == 0) continue;
        int newRow = row + dr;
        int newCol = col + dc;
        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
          if (board[newRow][newCol] == '*') {
            mineCount++;
          }
        }
      }
    }
    log.info("Adjacent mines counted successfully for the given cell {}", mineCount);
    return mineCount;
  }
}

