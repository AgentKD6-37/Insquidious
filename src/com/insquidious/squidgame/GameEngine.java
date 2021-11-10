package com.insquidious.squidgame;

import com.insquidious.squidgame.player.MainPlayer;
import com.insquidious.player.MainPlayer;
import com.insquidious.squidgame.board.RedLightGreenLight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

public class GameEngine {
    //static methods and fields

    //private fields
    private InputStream in;
    private FileOutputStream out = null;
    private Scanner scanner = new Scanner(System.in);
    private String saveGame = "Assets/save-game.properties";
    private MenuManager menuManager = new MenuManager();
    private MainPlayer player1 = new MainPlayer("Gi-hun",7);
    private FileManager fileManager = new FileManager();
    Properties saveFile;


    //business methods

    //runs the game and calls methods to continue through menus
    public void execute() throws IOException, InterruptedException {
        //load opening menu
        menuManager.MenuFiles();
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
                break;
            } else if (choice == 2) { //Continue from save file
                try {
                    playerRetrieveFromSave();
                    dormMenu();
                } catch(NullPointerException e){
                    System.out.println("No save game available!");
                    choice = 1;
                }

            } else if (choice == 3) { //skip the BS and play the game
                dormMenu();
                break;
            } else if (choice == 4){ //exit program
                System.exit(0);
            }
        }


    }

    void playerRetrieveFromSave() throws IOException, InterruptedException {
        saveFile = new Properties();
        in = new FileInputStream(saveGame);
        saveFile.load(in);
        in.close();
        player1.setPlayerName((String) saveFile.get("playerName"));
    }

    /*
     * Launches game by invoking the game manager
     */

    private void dormMenu() throws IOException {
        menuManager.dormMenuFiles();
        System.out.println(" ");
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Enter \"1\",\"2\" or \"3\"");
            System.out.print("");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            RedLightGreenLight game1 = new RedLightGreenLight();
            game1.redLightGreenLight();
        } else if (choice == 2) {
            gameListMenu();
        } else if (choice == 3){
            System.exit(0);
        }
        }

    private void gameListMenu() throws IOException {
        System.out.println("THERE IS CURRENTLY ONLY ONE GAME TO PLAY");
        dormMenu();
    }

    /*
     * End menu allows the player to exist after win or elimination.
     */

    private void endMenu(boolean bool) throws IOException, InterruptedException {
        //placeholder. eliminatedMenu loads by default.
        //TODO IF TRUE WIN IF FALSE LOSE
        menuManager.eliminatedMenuFiles();
        menuManager.winnerMenuFiles();
        Scanner playerInput = new Scanner(System.in);
        int choice = playerInput.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Enter \"1\" or \"2\"");
            System.out.println(" ");
            choice = playerInput.nextInt();
        } else if (choice == 1) {
            execute();
        } else if (choice == 2) {
            System.exit(0);
        }
    }

    public class MenuManager {

        public void getAssetFile(String fileName) throws IOException {
            String art = "Assets/" + fileName;
            var out = new BufferedOutputStream(System.out);
            Files.copy(Path.of(art), out);
            out.flush();
        }

        public void MenuFiles() throws IOException {

            getAssetFile("opening-menu-art.txt");
            getAssetFile("opening-menu-banner.txt");
            getAssetFile("opening-menu-dialogue.txt");
        }

        void dormMenuFiles() throws IOException {
            getAssetFile("dorm-menu-art.txt");
            getAssetFile("dorm-menu-dialogue.txt");
        }

        void eliminatedMenuFiles() throws IOException {
            getAssetFile("eliminated-menu-art.txt");
            getAssetFile("eliminated-menu-dialogue.txt");
        }

        void winnerMenuFiles() throws IOException {
            getAssetFile("winner-menu-art.txt");
            getAssetFile("winner-menu-dialogue.txt");
        }

        void gameListMenuFiles() throws IOException {
            getAssetFile("game-list-menu-dialogue.txt");
        }
    }

}