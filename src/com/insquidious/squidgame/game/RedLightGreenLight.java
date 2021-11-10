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
    public static final int TIMER = 120;

    /*
     * Fields for game management
     */
    private FileManager fileManager = new FileManager();
    private Properties save;
    MainPlayer humanPlayer;
    ComputerPlayer aiPlayer;
    private int playerDist;
    private String[][] boardGrid = new String[20][100];
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private String[] computerPlayerNames = {"Gi-Hun", "Sae-Byeok", "Ji-yeong", "Sang-woo", "Ali", "Il-nam",
            "Mi-nyeo", "Deok-su", "Byeong-gi", "Seok-jin", "Yoon-gi", "12. Ho-seok", "Nam-joon",
            "Ji-min", "Tae-hyung", "Jung-kook", "Yong-sun", "Byul-yi", "Whee-in"};
    private int playerSpd; //TODO READ SPEED FROM SAVE FILE, right now just using default values
    private String playerName = save.getProperty("playerName");

    /*
     * Game logic!
     */
    private boolean redLightGreenLight() throws IOException {
        loadPlayerProperties();

        Scanner scanner = new Scanner(System.in);   //Setting up for user input
        String playerInput = scanner.next();

        Dice d6 = new Dice();   //random rolls for Computer and Enemy

        addPlayers();
        initPlayerLocation();   //assign player spots on the board and fill the array

        //TODO: maybe change logic control overall to while round > 0 && humanPlayer.isAlive()
        int round = TIMER;  //right now not used

        //while(playerPos[][]!=[id][100]||timer !=0){
        //timer control
        for (int i = TIMER; i > 0; i--) {
            //assign random number to "catch" players if they move too far
            int enemy = d6.dieRoller();

            //cycle through all players getting their movement
            for (Player player : listOfPlayers) {
                //Get movement distance for Player objects
                if (player instanceof MainPlayer) {
                    //should possibly be replaced with a game engine method gameEngineSay()?
                    System.out.println("how far would you like to try and move? [PICK A NUMBER BETWEEN 1-100]");
                    this.playerDist = (scanner.nextInt());
                    //input validation
                    if (this.playerDist < 1 || this.playerDist > 100) {
                        //should possibly be replaced with a game engine method gameEngineSay()?
                        System.out.println("Number must be between 1-100");
                        this.playerDist = scanner.nextInt();
                    }
                    int playerTime = playerDist / playerSpd;    //calculate time from chosen player distance
                    checkElimination(playerTime, enemy, player);
                }else{  //this is the movement logic for Computer, assigned random rolled distance
                    if(player.isAlive()) {
                        int aiPlayerDist = d6.dieRoller();  //random number for computer player movement
                        int aiPlayerTime = aiPlayerDist / player.getPlayerSpd();
                        aiPlayerTime = playerDist / playerSpd;
                        checkElimination(aiPlayerTime, enemy, player);
                    }
                }

            }
                //TODO playerPos[][] = playerPos[id][y+playerDistance
        round--;
        }
        return true;
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
        Integer[] id = new Integer[(AI_PLAYER_COUNT + 1)];  //this array will hold all possible id numbers
        for(int i = 0; i != AI_PLAYER_COUNT; i++){
            aiPlayer = new ComputerPlayer(computerPlayerNames[i]);
            listOfPlayers.add(aiPlayer);
            id[i] = i+1;    //add a number to the pool of available id's (based on AI_PLAYER_COUNT)
        }
        //finally, add human player
        listOfPlayers.add(humanPlayer);
        //assigning random id's to each player
        Collections.shuffle(Arrays.asList(id)); //shuffles the available pool of id's
        for (int i = 0; i < listOfPlayers.size(); i++) {
            listOfPlayers.get(i).setPlayerID(id[i]);
        }
    }

    /*
     * The board grid has strings of P(layer), O(ther) to represent players in their starting(alive) states
     */
    public void initPlayerLocation() {
        for (Player player: listOfPlayers ) {
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
        if(time > enemy) {
            player.setAlive(false);
        }
    }





    // TODO: Create function to move players on board
    /*
    * Updates player location each round
    */
    // TODO: Change AI from X to O when dead
    public void updatePlayerLocation (Player player) {
        if (player instanceof MainPlayer) {

        }else {

        }
    }

    protected void drawBoard() {
        System.out.println("-----------------------------------------------------------------------------------"+
                "-----------------------------------------------------------------------------------"+
                "-----------------------------------------------------------------------------------"+
                "-----------------------------------------------------------------------------------"+
                "-----------------------------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.print("O" + " ");
            System.out.print("| ");
            for (int j = 0; j < 100; j++) {
                if (boardGrid[i][j] == null) {
                    System.out.print("  | ");
                } else {
                    System.out.print(boardGrid[i][j] + " | ");
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------"+
                    "-----------------------------------------------------------------------------------"+
                    "-----------------------------------------------------------------------------------"+
                    "-----------------------------------------------------------------------------------"+
                    "-----------------------------------------------------------------------");
        }
        System.out.println();
    }



}