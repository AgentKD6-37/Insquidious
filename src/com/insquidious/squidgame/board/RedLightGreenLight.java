package com.insquidious.squidgame.board;

//concrete implementation of BoardType

import com.insquidious.helpers.Dice;
import com.insquidious.player.ComputerPlayer;
import com.insquidious.player.MainPlayer;
import com.insquidious.player.Player;
import com.insquidious.squidgame.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class RedLightGreenLight {
    /*
     * Fields for game management
     */
    private FileManager fileManager = new FileManager();
    private Properties save;
    private String playerName = save.getProperty("playerName");
    MainPlayer humanPlayer = new MainPlayer(playerName);
    private int playerSpd;
    private int playerDist;
    private int enemy;
    private int timer = 120;
    private int playerTime = playerDist / playerSpd;
    private static final int AI_PLAYER_COUNT = 19;


    private boolean redLightGreenLight(int players) {
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.next();
        Dice d6 = new Dice();
        ArrayList<Player> listOfPlayers = new ArrayList<>();

        String[] computerPlayerNames = {"Gi-Hun", "Sae-Byeok", "Ji-yeong", "Sang-woo", "Ali", "Il-nam",
                "Mi-nyeo", "Deok-su", "Byeong-gi", "Seok-jin", "Yoon-gi", "12. Ho-seok", "Nam-joon",
                "Ji-min", "Tae-hyung", "Jung-kook", "Yong-sun", "Byul-yi", "Whee-in"};

        ComputerPlayer aiPlayers;
        for(int i = 0; i < AI_PLAYER_COUNT; i++){
            aiPlayers = new ComputerPlayer(computerPlayerNames[i]);
            listOfPlayers.add(aiPlayers);
        }

        listOfPlayers.add(humanPlayer);
        int Round = 0;
        //while(playerPos[][]!=[id][100]||timer !=0){
        for (int i = timer; i > 0; i--) {
            enemy = d6.dieRoller();
            for (Object player : listOfPlayers) {
                if (player == this.humanPlayer) {
                    System.out.println("how far would you like to try and move? [PICK A NUMBER BETWEEN 1-100]");
                    this.playerDist = scanner.nextInt();
                    if (this.playerDist < 1 || this.playerDist > 100) {
                        System.out.println("Number must be between 1-100");
                        this.playerDist = scanner.nextInt();
                    }
                }else{
                    //if(aiIsAlive){
                    int aiPlayerDist = d6.dieRoller();
                    int aiPlayerTime = aiPlayerDist/5;
                    if(aiPlayerTime > enemy){
                        //AI changes from O to X on board
                        //AI is set to dead
                    }
                }
            }
            if(playerTime > enemy){
                humanPlayer.setAlive(false);
                return false;
            }else{
                //playerPos[][] = playerPos[id][x+playerDist]
            }
        timer--;
        }
        return true;
    }

    private void loadPlayerProperties() throws IOException {
        this.save = fileManager.getSaveFile();
    }


}