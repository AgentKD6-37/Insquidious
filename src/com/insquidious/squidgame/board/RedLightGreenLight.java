package com.insquidious.squidgame.board;

//concrete implementation of BoardType

import java.util.ArrayList;
import java.util.List;

public class RedLightGreenLight extends Board {
    //static fields
    public static final Integer LENGTH = 100;
    public static final Integer WIDTH = 20;
    public static final Integer MAX_PLAYERS = 20;
    //TODO: Time synchronization or implement time countdown
    public static final Integer TIME_LIMIT = 120_000;

    //fields
    private static List<Integer> playerList= new ArrayList<Integer>();
    private static List<Integer> rows= new ArrayList<Integer>();

    //Constructors
    RedLightGreenLight() {
        super(BoardType.RLGL, LENGTH, WIDTH);
        initBoard();
    }

    //Methods

    /*
    * Method moves Player objects across the board
    * TODO: need to coordinate with Zrybea about controlling the speed of the player across
    *  the board, pass speed? convert speed to movement? I also need a way to track each players current row.
    */
    public void movePlayer() {
        int moveForward;
        while (true){

        }
    }

    /*
     * This initializes the 2d array that represents the game board.
     * The rows are the outer ArrayList. Rows will start at 0.
     * Max number of rows determined by LENGTH variable.
     */
    @Override
    protected void initBoard() {
        //test method
        System.out.println("Creating red light, green light board!");

        ArrayList<ArrayList<Integer>> boardGrid =new ArrayList<ArrayList<Integer> >();

        //adds the first "row" to the board starting at 0
        boardGrid.add(new ArrayList<Integer>());

        System.out.println("Adding players.");

        //Adding player ids for inner list
        //TODO: This will need to be swapped for player objects
        for (int i = 1; i < (MAX_PLAYERS+1); i++) {
            playerList.add(i);
        }

        //creating rows for the outer array list
        //TODO: Will need to swap Integer for Player
        for (Integer player: playerList) {
            //adding players to the starting row 0
            boardGrid.get(0).add(player);
        }
    }


}