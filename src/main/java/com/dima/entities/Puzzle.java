package com.dima.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Puzzle {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private final String name;
    private final String puzzleString;
    private final String difficulty;
    private final Date doc;
    public Puzzle(String name, String puzzleString, String difficulty) {
        this.name = name;
        this.puzzleString = puzzleString;
        this.difficulty = difficulty;
        doc = new Date();
    }

    public String getName() {
        return name;
    }

    public String getPuzzleString() {
        return puzzleString;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getDocString() {
        return formatter.format(doc);
    }
}
