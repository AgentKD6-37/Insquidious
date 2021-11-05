package com.insquidious.squidgame;

import java.io.IOException;

public class GameEngine {
    //static methods and fields

    //private fields

    //fields

    //ctors

    //business methods

    /*
     * Execute will invoke all of the required classes for game start. It will also check for a save file and if available, load the game at that save state.
     */
    public void execute() throws IOException {

        //check for save
        FileManager fileManager = new FileManager();
        fileManager.getSaveFile();

        //load opening menu
        MenuManager menuManager = new MenuManager();
        menuManager.openingMenu();

    }
}
