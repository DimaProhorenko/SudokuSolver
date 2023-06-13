package com.dima;

import com.dima.utils.Constants;
import com.dima.utils.Helpers;

public class Board {

    private int[][] grid;

    public Board() {
        grid = new int[Constants.GRID_SIZE][Constants.GRID_SIZE];
        generateBoard();
    }

    public void generateBoard() {
        int rowPosition = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        int colPosition = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        int firstValue = Helpers.getRandomInt(Constants.MIN_VALID_NUMBER, Constants.MAX_VALID_NUMBER);
        grid[rowPosition][colPosition] = firstValue;
    }

    public int[][] getGrid() {
        return grid;
    }
}
