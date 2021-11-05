package com.insquidious.squidgame;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/*
 * Class passes a set of art assets to the engine
 */

public class MenuManager {
    Scanner playerInput = new Scanner(System.in);
    FileManager fileManager = new FileManager();

    public void MenuFiles() throws IOException {

        fileManager.getArtFile("opening-menu-art.txt");
        fileManager.getArtFile("opening-menu-banner.txt");
        fileManager.getArtFile("opening-menu-dialogue.txt");
    }

     void dormMenuFiles() throws IOException {
        fileManager.getArtFile("dorm-menu.txt");
        fileManager.getArtFile("dorm-menu-dialogue.txt");
    }

    void eliminatedMenuFiles() throws IOException{
        fileManager.getArtFile("eliminated-menu-art.txt");
        fileManager.getArtFile("eliminated-menu-dialogue");
    }

    void winnerMenuFiles() throws IOException{
        fileManager.getArtFile("winner-menu-art.txt");
        fileManager.getArtFile("winner-menu-dialogue");
    }
}
