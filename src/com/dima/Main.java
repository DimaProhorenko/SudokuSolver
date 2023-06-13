package com.dima;

public class Main {
    public static void main(String[] args) {
        // Test random cell position
        Board board = new Board();
        Sudoku sudoku = new Sudoku(board);
        sudoku.printBoard();
    }
}
