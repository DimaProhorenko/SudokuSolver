package com.dima.controllers;

import com.dima.entities.Puzzle;
import com.dima.models.SavePuzzleModel;
import com.dima.views.SavePuzzleView;

public class SavePuzzleController {
    private SavePuzzleView view;
    private SavePuzzleModel model;

    public SavePuzzleController() {
        view = new SavePuzzleView();
        model = new SavePuzzleModel();
    }

    public void handleData() {
        Puzzle puzzle  = view.getData();
        if (model.validatePuzzleString(puzzle.getPuzzleString())) {
            if (model.savePuzzleToDB(puzzle)) {
                view.printSuccessMessage();
            }
        } else {
            System.out.println("Error in puzzle string");
        }
    }
}
