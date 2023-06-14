package com.dima;

import com.dima.utils.Constants;
import com.dima.utils.Helpers;

public class Board {

    private int[][] grid;

    public Board() {
        grid = new int[Constants.GRID_SIZE][Constants.GRID_SIZE];
        generateBoard();
    }
    public Board(String puzzleString) {
        grid = generateGrid(puzzleString);
    }

    public int[][] getGrid() {
        return grid;
    }

    public void printBoard() {
        for (int row = 0; row < Constants.GRID_SIZE; row++) {
            if (row % Constants.BOX_SIZE == 0 && row != 0) {
                for (int i = 0; i < Constants.GRID_SIZE * 2 + 1; i++) {
                    System.out.print("-");
                }
                System.out.println();

            }
            for (int col = 0; col < Constants.GRID_SIZE; col++) {
                if (col % Constants.BOX_SIZE == 0 && col != 0) {
                    System.out.print("|");
                }
                if (grid[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean solve() {
        for (int row = 0; row < Constants.GRID_SIZE; row++) {
            for (int column = 0; column < Constants.GRID_SIZE; column++) {
                if (grid[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= Constants.GRID_SIZE; numberToTry++) {
                        if (isPlacementValid(numberToTry, row, column)) {
                            grid[row][column] = numberToTry;

                            if (solve()) {
                                return true;
                            }
                            else {
                                grid[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void generateBoard() {
        int rowPosition = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        int colPosition = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        int firstValue = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        grid[rowPosition][colPosition] = firstValue;
        solve();
    }

    private int[][] generateGrid(String gridString) {
        int[][] resultGrid = new int[Constants.GRID_SIZE][Constants.GRID_SIZE];
        int counter = 0;
        for (int row = 0; row < Constants.GRID_SIZE; row++) {
            for (int col = 0; col < Constants.GRID_SIZE; col++) {
                resultGrid[row][col] = Integer.parseInt(String.valueOf(gridString.charAt(counter)));
                counter++;
            }
        }
        return resultGrid;
    }


    private boolean isNumberInRow(int number, int row) {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (grid[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInColumn(int number, int column) {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (grid[i][column] == number) {
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
                if (grid[i][j] == number) {
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
