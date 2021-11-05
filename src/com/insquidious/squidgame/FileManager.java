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

class FileManager {

    private FileInputStream in = null;
    private FileOutputStream out = null;
    private FileWriter writer;
    private Scanner scanner = new Scanner(System.in);
    private FileReader reader;
    private String saveGame = "save-game.properties";
    public Properties save;

    //returns the save file to the game engine to be read
    public void getSaveFile(Properties flag) throws IOException {
        in = new FileInputStream(saveGame);
    }

    public void getArtFile(String fileName) throws IOException{
        String art = "Assets/" + fileName;
        var out = new BufferedOutputStream(System.out);
        Files.copy(Path.of(art), out);
        out.flush();
    }


    //save-game.properties is set by default to null/0 values and then overwritten by the newPlayerCreator
    void newPlayerCreator() throws IOException {
        in = new FileInputStream(saveGame);
        save.load(in);
        out = new FileOutputStream(saveGame);
        System.out.print("What is your name? : ");
        String name = scanner.next();
        if(name != null){
            save.put("playerName", name );
        }else{
            System.out.println("Name cannot be empty!");
            name = scanner.next();
        }
        System.out.print("Have you played this game before? [Y/N] : ");
        String newPlayer = scanner.next();
        if (newPlayer.equals("N")) {
            save.put("newPlayer", false);
        } else {
            System.out.println("Enter only Y or N");
            newPlayer = scanner.next();
        }
        in.close();
        out.close();
    }

}
