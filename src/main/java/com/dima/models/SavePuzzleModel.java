package com.dima.models;

import com.dima.Board;
import com.dima.database.DBConnection;
import com.dima.database.DBConstants;
import com.dima.entities.Puzzle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavePuzzleModel {

    public boolean savePuzzleToDB(Puzzle puzzle) {
        String sql = "INSERT INTO %s (%s, %s, %s, %s) VALUES(?, ?, ?, ?)"
                .formatted(DBConstants.TABLE_PUZZLES,
                        DBConstants.COLUMN_PUZZLES_NAME, DBConstants.COLUMN_PUZZLES_DIFFICULTY,
                        DBConstants.COLUMN_PUZZLES_PUZZLE, DBConstants.COLUMN_PUZZLES_DOC
                        );
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, puzzle.getName());
            pstmt.setString(2, puzzle.getDifficulty());
            pstmt.setString(3, puzzle.getPuzzleString());
            pstmt.setString(4, puzzle.getDocString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(DBConstants.DB_ADD_PUZZLE_ERROR + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean validatePuzzleString(String puzzleString) {
        if (checkIfStringNumeric(puzzleString) && new Board(puzzleString).solve()) {
            return true;
        }
        return false;
    }

    private boolean checkIfStringNumeric(String test) {
        return test.matches("[0-9]+");
    }
}
