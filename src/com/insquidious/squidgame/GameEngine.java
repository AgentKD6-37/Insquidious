package com.insquidious.squidgame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

public class GameEngine {
    //static methods and fields

    //private fields
    private FileInputStream in = null;
    private FileOutputStream out = null;
    private FileWriter writer;
    private Scanner scanner = new Scanner(System.in);
    private FileReader reader;
    private String saveGame = "Assets/save-game.properties";
    public Properties save;
    private MenuManager menuManager = new MenuManager();
    //fields

    //ctors

    //business methods
    /*
     * Execute will invoke all of the required classes for game start. It will also check for a save file and if available, load the game at that save state.
     */
    public void execute() throws IOException {
        //load opening menu
        menuManager.MenuFiles();
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        //Start Menu Options
        while (choice != 3) {

            if (choice < 1 || choice > 3) {

                System.out.println("Enter \"1\", \"2\", or \"3\"");
                choice = playerInput.nextInt();

            } else if (choice == 1) {
                newPlayerCreator();
                break;
            } else if (choice == 2) {
                dormMenu();
                break;
            } else if (choice == 3) {
                System.exit(0);
            }
        }


    }

    /*
     * Creates a new player save file off the inputs.
     */
    void newPlayerCreator() throws IOException {
        save = new Properties();
        in = new FileInputStream(saveGame);
        save.load(in);
        in.close();
        out = new FileOutputStream(saveGame);
        System.out.print("What is your name? : ");
        String name = scanner.next();
        save.put("playerName", name);
        System.out.print("Have you played this game before? [Y/N] : ");
        String newPlayer = scanner.next();
        if (newPlayer.equals("N")) {
            save.put("newPlayer", false);
        } else {
            System.out.println("Enter only Y or N");
            newPlayer = scanner.next();
        }
        save.store(out, "Player Save File");
        out.close();
    }

    public Properties getSaveFile() throws IOException {
        save = new Properties();
        in = new FileInputStream(saveGame);
        save.load(in);
        return save;
    }


    /*
     * Launches game by invoking the game manager
     */

    private void dormMenu() throws IOException {
        menuManager.dormMenuFiles();
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Enter \"1\" or \"2\"");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            System.out.println("launching game");
        } else if (choice == 2) {
            System.exit(0);

        }
    }

    /*
     * End menu allows the player to exist after win or elimination.
     */

    private void endMenu() throws IOException {
        //placeholder eliminate loads by dafault.
        //TODO: Implement read from save file to determine if win, then display winner art.
        menuManager.eliminatedMenuFiles();
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Enter \"1\" or \"2\"");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            execute();
        } else if (choice == 2) {
            System.exit(0);

        }
    }
}
