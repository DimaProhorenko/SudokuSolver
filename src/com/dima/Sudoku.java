package com.dima;

import com.dima.utils.Constants;

public class Sudoku {
    private Board board;

    public Sudoku(Board board) {
        this.board = board;
    }

    private boolean isNumberInRow(int number, int row) {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (board.getGrid()[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInColumn(int number, int column) {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (board.getGrid()[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(int number, int row, int column) {
        int beginRow = row - row % Constants.BOX_SIZE;
        int beginCol = column - column % Constants.BOX_SIZE;

        for (int i = beginRow; i < beginRow + Constants.BOX_SIZE; i++) {
            for (int j = beginCol; j < beginCol + Constants.BOX_SIZE; j++) {
                if (board.getGrid()[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPlacementValid(int number, int row, int column) {
        return (!isNumberInRow(number, row) &&
                !isNumberInColumn(number, column) &&
                !isNumberInBox(number, row, column));
    }
}
