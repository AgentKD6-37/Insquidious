package com.insquidious.squidgame;

import java.io.IOException;
import java.util.Scanner;

public class MenuManager {
    Scanner playerInput = new Scanner(System.in);
    FileManager fileManager = new FileManager();

    public void openingMenu() throws IOException {

        fileManager.getOpeningMenuArt();
        System.out.println("");
        System.out.println("Welcome. Would you like to Play?");
        System.out.println("1 - New Story Game");
        System.out.println("2 - Mini Game Selector");
        System.out.println("3 - Exit");
        System.out.println("");
        System.out.println("");
        System.out.println("Please select a number to continue");
        int choice = playerInput.nextInt();
        while (choice != 3) {

            if (choice < 1 || choice > 3) {

                System.out.println("Enter \"1\", \"2\", or \"3\"");
                choice = playerInput.nextInt();

            } else if (choice == 1) {
                System.out.println("What is your name?");
                String name = playerInput.next();
                fileManager.setSaveFile(name);
            } else if (choice == 2) {
                dormMenu();
            } else if (choice == 3) {
                System.exit(0);
            }

        }
    }

    private void dormMenu() {
    }
}
