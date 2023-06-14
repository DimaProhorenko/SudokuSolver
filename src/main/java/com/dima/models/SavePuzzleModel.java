package com.dima.models;

import com.dima.Board;
import com.dima.database.DBConnection;
import com.dima.database.DBConstants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavePuzzleModel {

    public boolean savePuzzleToDB(String[] data) {
        String sql = "INSERT INTO %s (%s, %s, %s, %s) VALUES(?, ?, ?, ?)"
                .formatted(DBConstants.TABLE_PUZZLES,
                        DBConstants.COLUMN_PUZZLES_NAME, DBConstants.COLUMN_PUZZLES_DIFFICULTY,
                        DBConstants.COLUMN_PUZZLES_PUZZLE, DBConstants.COLUMN_PUZZLES_DOC
                        );
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, data[0]);
            pstmt.setString(2, "Easy");
            pstmt.setString(3, data[1]);
            pstmt.setString(4, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
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
