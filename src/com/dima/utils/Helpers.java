package com.dima.utils;
import java.util.Random;
public class Helpers {
    private static Random random = new Random();
    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
