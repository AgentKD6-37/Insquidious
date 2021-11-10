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
     * Fields for game management
     */
    private FileManager fileManager = new FileManager();
    private Properties save;
    private String playerName = save.getProperty("playerName");
    MainPlayer humanPlayer;
    ComputerPlayer aiPlayer;
    private int playerSpd; //TODO READ SPEED FROM SAVE FILE, right now just using default values
    private int playerDist;
    private int enemy;
    private int timer = 120;
    private int playerTime = playerDist / playerSpd;
    private static final int AI_PLAYER_COUNT = 19;
    private String[][] boardGrid = new String[20][100];
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private String[] computerPlayerNames = {"Gi-Hun", "Sae-Byeok", "Ji-yeong", "Sang-woo", "Ali", "Il-nam",
            "Mi-nyeo", "Deok-su", "Byeong-gi", "Seok-jin", "Yoon-gi", "12. Ho-seok", "Nam-joon",
            "Ji-min", "Tae-hyung", "Jung-kook", "Yong-sun", "Byul-yi", "Whee-in"};


    /*
     * Game logic!
     */

    private boolean redLightGreenLight() throws IOException {
        loadPlayerProperties();
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.next();
        Dice d6 = new Dice();

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

        initPlayerLocation();   //assign player spots on the board and fill the array

        int Round = 0;
        //while(playerPos[][]!=[id][100]||timer !=0){
        for (int i = timer; i > 0; i--) {
            enemy = d6.dieRoller();
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

                }else{
                    if(player.isAlive()) {
                        int aiPlayerDist = d6.dieRoller();  //random number for computer player movement
                        int aiPlayerTime = aiPlayerDist / player.getPlayerSpd();
                        if(aiPlayerTime > enemy){
                            //DONE AI is set to dead
                            player.setAlive(false);
                            // updatePlayerLocation(); shifting movement and updating board to outside this  logic

                        }
                    }

                }
            }
            if(playerTime > enemy){
                humanPlayer.setAlive(false);
                return false;
            }else{
                //TODO playerPos[][] = playerPos[id][y+playerDist]
            }
        timer--;
        }
        return true;
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

    private void loadPlayerProperties() throws IOException {
        this.save = fileManager.getSaveFile();
    }


}