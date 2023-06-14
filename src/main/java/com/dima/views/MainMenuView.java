package com.dima.views;

import com.dima.controllers.MainMenuController.Paths;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuView {

    public Paths getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Generate puzzle\n2 - Get random puzzle\n3 - Save puzzle\n0 - Exit");
        try {
            int choice = scanner.nextInt();
            return Paths.values[choice];
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Wrong input ");
        }


        return null;
    }
}
