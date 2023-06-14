package com.dima.controllers;

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
        String[] puzzleData = view.getData();
        if (model.validatePuzzleString(puzzleData[1])) {
            if (model.savePuzzleToDB(puzzleData)) {
                view.printSuccessMessage();
            }
        } else {
            System.out.println("Error in puzzle string");
        }
    }
}
