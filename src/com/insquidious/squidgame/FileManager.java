package com.insquidious.squidgame;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

/*
 *File manager can import, read, write, or create files
 */

public class FileManager {

    private FileInputStream in = null;
    private FileOutputStream out = null;
    private FileWriter writer;
    private Scanner scanner = new Scanner(System.in);
    private FileReader reader;
    private String saveGame = "Assets/save-game.properties";
    public Properties save;

    //returns the save file to the game engine to be read
    public void getSaveFile(Properties flag) throws IOException {
        in = new FileInputStream(saveGame);
    }

    public void getAssetFile (String fileName) throws IOException{
        String art = "Assets/" + fileName;
        var out = new BufferedOutputStream(System.out);
        Files.copy(Path.of(art), out);
        out.flush();
    }


    //save-game.properties is set by default to null/0 values and then overwritten by the newPlayerCreator

    public Properties getSaveFile() throws IOException {
        try {
            save = new Properties();
            in = new FileInputStream(saveGame);
            save.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }return save;
    }

}
