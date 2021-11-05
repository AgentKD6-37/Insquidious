package com.insquidious.squidgame;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 *File manager can import, read, write, or create files
 */

class FileManager {

    private FileInputStream in = null;
    private FileOutputStream out = null;
    private FileWriter writer;
    private FileReader reader;
    private String saveGame = "Assets/save-game.txt";
    public File save;
    public File openingMenu;

    //returns the save file to the game engine to be read
    public void getSaveFile() throws IOException {
        this.save = new File(saveGame);
        if (save.exists()){
            in = new FileInputStream(String.valueOf(Path.of(saveGame)));
            in.close();
        }else{
            System.out.println("No save file exists for this player");
        }
    }

    //creates and writes to a new save file
    public void setSaveFile(String name) throws IOException {
        this.save = new File(saveGame);
        out = new FileOutputStream(String.valueOf(Path.of(saveGame)));
        writer = new FileWriter(save);
        writer.write(name);
        writer.close();
        out.close();
    }

    public void getOpeningMenuArt() throws IOException{
        String openingMenuArt = "Assets/opening-menu-art.txt";
        String openingMenuBanner = "Assets/opening-menu-banner.txt";
        var out = new BufferedOutputStream(System.out);
        Files.copy(Path.of(openingMenuArt), out);
        Files.copy(Path.of(openingMenuBanner), out);
        out.flush();
    }



}
