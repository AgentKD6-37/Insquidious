package com.insquidious.squidgame.game;

//concrete implementation of BoardType

import com.insquidious.squidgame.util.Dice;
import com.insquidious.squidgame.player.ComputerPlayer;
import com.insquidious.squidgame.player.MainPlayer;
import com.insquidious.squidgame.player.Player;
import com.insquidious.squidgame.FileManager;

import java.io.IOException;
import java.util.*;

public class RedLightGreenLight {
    /*
     * Static Fields
     */
    public static final int AI_PLAYER_COUNT = 19;
    public static final int TIMER = 60;

    /*
     * Fields for game management
     */
    private FileManager fileManager = new FileManager();
    private Properties save;
    MainPlayer humanPlayer;
    ComputerPlayer aiPlayer;
    private String[][] boardGrid = new String[20][100];
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private String[] computerPlayerNames = {"Gi-Hun", "Sae-Byeok", "Ji-yeong", "Sang-woo", "Ali", "Il-nam",
            "Mi-nyeo", "Deok-su", "Byeong-gi", "Seok-jin", "Yoon-gi", "Ho-seok", "Nam-joon",
            "Ji-min", "Tae-hyung", "Jung-kook", "Yong-sun", "Byul-yi", "Whee-in"};

    /*
     * Game logic!
     */
    public boolean redLightGreenLight() throws IOException {
        int playerTime;
        int choice = 0;
        loadPlayerProperties();
        String playerName = save.getProperty("playerName");
        humanPlayer = new MainPlayer(playerName, 5);
        Scanner playerDist = new Scanner(System.in);   //Setting up for user input
        Dice d20Enemy = new Dice(20);   //random rolls for Enemy
        Dice d6Comp = new Dice();      //random rolls for Comp
        addPlayers();
        initPlayerLocation();   //assign player spots on the board and fill the array
        drawBoard();
        int round = TIMER;
        //timer control
        for (int i = TIMER; i > 0; i--) {
            //assign random number to "catch" players if they move too far
            int enemy = d20Enemy.roll();

            //cycle through all players getting their movement
            for (Player player : listOfPlayers) {
                //Get movement distance for Player objects
                if (player instanceof MainPlayer && humanPlayer.isAlive()) {
                    System.out.println("Green light!");
                    System.out.println("how far would you like to try and move? [PICK A NUMBER BETWEEN 1-50]");
                    choice = playerDist.nextInt();
                    System.out.println("Red light!");
                    //input validation
                    if (choice < 1 || choice > 50) {
                        System.out.println("Number must be between 1-50");
                        choice = playerDist.nextInt();
                    }

                    playerTime = choice / player.getPlayerSpd();    //calculate time from chosen player distance
                    checkElimination(playerTime, enemy, player);
                } else if (player instanceof MainPlayer && !humanPlayer.isAlive()) {
                    break;
                } else {  //this is the movement logic for Computer, assigned random rolled distance
                    if (player.isAlive()) {
                        choice = d6Comp.roll();  //random number for computer player movement

                        playerTime = choice / player.getPlayerSpd();
                        checkElimination(playerTime, enemy, player);
                    }
                }
                updatePlayerLocation(player, choice);   //move current player across the board

            }
            if (!humanPlayer.isAlive()) {
                break;
            } else {
                if (humanPlayer.getYCoordinate() != 99) {
                    drawBoard();
                    round--;
                    System.out.println("There are " + round + " seconds remaining! You need to make it another " + (99 - humanPlayer.getYCoordinate()) + " meters!");
                } else {
                    break;
                }
            }
        }
        if(round <= 0){
            humanPlayer.setAlive(false);
        }
            return humanPlayer.isAlive();
    }

    /*
     * Pulls MainPlayer properties from file (name, speed...)
     */
    private void loadPlayerProperties() throws IOException {
        this.save = fileManager.getSaveFile();
    }

    /*
     * Adds players to the board. Assign names and random id's to player
     */
    private void addPlayers() {
        //creating AI players and adding them to the board

        for (int i = 0; i < AI_PLAYER_COUNT; i++) {
            aiPlayer = new ComputerPlayer(computerPlayerNames[i]);
            listOfPlayers.add(aiPlayer);
        }
        //finally, add human player
        listOfPlayers.add(humanPlayer);
        //assigning id's to each player
        for (int i = 0; i < listOfPlayers.size(); i++) {
            listOfPlayers.get(i).setPlayerID(i);
        }
    }

    /*
     * The board grid has strings of P(layer), O(ther) to represent players in their starting(alive) states
     */
    public void initPlayerLocation() {
        for (Player player : listOfPlayers) {
            if (player instanceof MainPlayer) {
                int x = humanPlayer.getPlayerID();
                boardGrid[x][0] = "P";
            } else {
                int x = player.getPlayerID();
                boardGrid[x][0] = "O";
            }
        }
    }

    /*
     * Determines if the player has been eliminated from the game
     * if they try to exceed enemy speed isAlive set to false
     */
    private void checkElimination(int time, int enemy, Player player) {
        if (time > enemy && player.getYCoordinate() != 99) {
            player.setAlive(false);
            boardGrid[player.getPlayerID()][player.getYCoordinate()] = "X";
            if (player != humanPlayer) {
                System.out.println(player.getPlayerName() + " Has been eliminated!");
            }
        }
    }

    /*
     * Updates player location each round
     */

    public void updatePlayerLocation(Player player, int distance) {
        int move = player.getYCoordinate();
        int oldY = player.getYCoordinate();
        move = move + distance;
        if (move > 99) {
            move = 99;
        }
        if (player.isAlive()) {
            player.setYCoordinate(move);
            if (player.equals(humanPlayer)) {
                boardGrid[player.getPlayerID()][move] = "P";
            } else {
                boardGrid[player.getPlayerID()][move] = "O";
            }
            boardGrid[player.getPlayerID()][oldY] = " ";
        }
    }

    protected void drawBoard() {
        System.out.println("--------------------------------------------------" +
                "--------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 100; j++) {
                if (boardGrid[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(boardGrid[i][j]);
                }
            }
            System.out.println();
            System.out.println("--------------------------------------------------" +
                    "--------------------------------------------------");
        }
        System.out.println();
    }
}