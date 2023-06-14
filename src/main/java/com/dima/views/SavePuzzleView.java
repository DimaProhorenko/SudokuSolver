package com.dima.views;

import com.dima.database.DBConstants;
import com.dima.entities.Puzzle;

import java.util.Scanner;

public class SavePuzzleView {

    public Puzzle getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your puzzle string (In rows from left to right, empty cells must be 0)");
        String puzzleString = scanner.nextLine();
        System.out.println("Enter puzzle name without spaces");
        String puzzleName = scanner.next();
        return new Puzzle(puzzleName, puzzleString, "easy");
    }

    public void printSuccessMessage() {
        System.out.println(DBConstants.DB_ADD_PUZZLE_SUCCESS);
    }
}
