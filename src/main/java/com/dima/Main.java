package com.dima;

import com.dima.controllers.MainMenuController;
import com.dima.database.DBConnection;
import com.dima.entities.Puzzle;

public class Main {
    public static void main(String[] args) {
        DBConnection.connect();
        MainMenuController mmc = new MainMenuController();
        mmc.handleData();
        // Test random cell position
        Board board = new Board("003020600900305001001806400008102900700000008006708200002609500800203009005010300");
        DBConnection.close();
    }
}
