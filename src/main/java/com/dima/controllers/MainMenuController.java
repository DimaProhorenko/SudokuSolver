package com.dima.controllers;

import com.dima.views.MainMenuView;

public class MainMenuController {
    public enum Paths {
        EXIT(0),
        GENERATE_PUZZLE(1),
        GET_RANDOM_PUZZLE(2),
        SAVE_PUZZLE(3);

        private int value;

        public int getValue() {
            return value;
        }

        public static Paths[] values = values();

        Paths(int value) {
            this.value = value;
        }
    }


    private MainMenuView view;

    public MainMenuController() {
        view = new MainMenuView();
    }


    public void handleData() {
        Paths path = null;
        while (path != Paths.EXIT) {
            path = view.getData();
//            switch (path) {
//                case SAVE_PUZZLE -> System.out.println();
//            }
        }
    }

}
