package com.insquidious.squidgame;

import com.insquidious.squidgame.game.RedLightGreenLight;
import com.insquidious.squidgame.player.MainPlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class GameEngine {
    //fields
    private final MainPlayer player1 = new MainPlayer("Gi-hun", 7);
    private final FileManager fileManager = new FileManager();
    Properties saveFile;

    //**business methods

    //runs the game and calls methods to continue through menus
    public void execute() throws IOException, InterruptedException {
        //load opening menu
        fileManager.MenuFiles();
        System.out.println(":");
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        //Start Menu Options
        while (choice != 4) {

            if (choice < 1 || choice > 4) {

                System.out.println("Enter \"1\", \"2\", 3, or \"4\"");
                System.out.println(" ");
                choice = playerInput.nextInt();

            } else if (choice == 1) { //Create new player
                fileManager.newPlayerCreator();
                pressEnterToContinue();
                dormMenu();
                break;
            } else if (choice == 2) { //Continue from save file
                try {
                    playerRetrieveFromSave();
                    dormMenu();
                } catch (NullPointerException e) {
                    System.out.println("No save game available!");
                    choice = 1;
                }

            } else if (choice == 3) { //skip the BS and play the game
                dormMenu();
                break;
            } else if (choice == 4) { //exit program
                System.exit(0);
            }
        }


    }

    void playerRetrieveFromSave() throws IOException, InterruptedException {
        saveFile = new Properties();
        //private fields
        // class fields
        String saveGame = "Assets/save-game.properties";
        InputStream in = new FileInputStream(saveGame);
        saveFile.load(in);
        in.close();
        player1.setPlayerName((String) saveFile.get("playerName"));
    }

    /*
     * Launches game by invoking the game manager
     */

    private void dormMenu() throws IOException, InterruptedException {
        fileManager.dormMenuFiles();
        System.out.println(" ");
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Enter \"1\",\"2\" or \"3\"");
            System.out.print("");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            fileManager.getAssetFile("RLGL-intro-and-rules");
            pressEnterToContinue();
            RedLightGreenLight game1 = new RedLightGreenLight();
            boolean didLive = game1.redLightGreenLight();
            endMenu(didLive);
        } else if (choice == 2) {
            gameListMenu();
        } else if (choice == 3) {
            System.exit(0);
        }
    }

    private void gameListMenu() throws IOException, InterruptedException {
        System.out.println("THERE IS CURRENTLY ONLY ONE GAME TO PLAY");
        pressEnterToContinue();
        dormMenu();
    }

    /*
     * End menu allows the player to exist after win or elimination.
     */

    private void endMenu(boolean bool) throws IOException, InterruptedException {
        Scanner playerInput = new Scanner(System.in);
        if (bool) {
            fileManager.winnerMenuFiles();
        } else {
            fileManager.eliminatedMenuFiles();
        }
        System.out.print("");
        System.out.print("Please select an option: ");
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Enter \"1\" or \"2\"");
            System.out.print(" ");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            execute();
        } else if (choice == 2) {
            System.exit(0);
        }


    }

    private void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}