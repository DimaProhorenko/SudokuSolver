package com.dima;

import com.dima.utils.Constants;

public class Sudoku {
    private Board board;

    public Sudoku(Board board) {
        this.board = board;
    }

    public void printBoard() {
        int[][] grid = board.getGrid();
        for (int row = 0; row < Constants.GRID_SIZE; row++) {
            if (row % Constants.BOX_SIZE == 0 && row != 0) {
                System.out.println("-".repeat(Constants.GRID_SIZE + Constants.BOX_SIZE - 1));
            }
            for (int col = 0; col < Constants.GRID_SIZE; col++) {
                if (col % Constants.BOX_SIZE == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
}
