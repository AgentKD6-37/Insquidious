package com.insquidious.squidgame.board;

//concrete implementation of BoardType

import java.util.ArrayList;

public class RedLightGreenLight extends Board {
    //static fields
    public static final Integer LENGTH = 100;
    public static final Integer WIDTH = 20;
    public static final Integer MAX_PLAYERS = 20;

    //fields
    private static ArrayList<Integer> playerList= new ArrayList<Integer>();
    private static ArrayList<Integer> rows= new ArrayList<Integer>();

    //Constructors
    RedLightGreenLight() {
        super(BoardType.RLGL, LENGTH, WIDTH);
        initBoard();
    }

    //Methods
    @Override
    protected void initBoard() {
        //test method
        System.out.println("Creating red light, green light board!");

        /*
        * This initializes the 2d array that represents the game board.
        * The rows are the outer ArrayList. Rows will start at 0.
        */
        ArrayList<ArrayList<Integer>> boardGrid =new ArrayList<ArrayList<Integer> >();

        //adds the first "row" to the board starting at 0
        boardGrid.add(new ArrayList<Integer>());

        System.out.println("Adding players.");

        //Adding player ids for inner list
        //TODO: This will need to be swapped for player objects
        for (int i = 1; i < (MAX_PLAYERS+1); i++) {
            playerList.add(i);
        }

        //this will place the players on the board and set up the first row in the board


        //creating rows for the outer array list
        for (int i = 0; i < WIDTH; i++) {

        }
        boardGrid.add(playerList);
    }


    //TODO:Danger! There be dragons below here.
    /*//static fields
    private static final double TIME_LIMIT = 120000;


    private List<Integer> players = new ArrayList();    //This would be shifted to a List<Players>

    private int[] initPosition = {0, 0};    //Players have a field to contain their location, or board keeps positions by ID
    private Integer initPlayerID = 0;       //these values are only used to "wipe" the board when started

    private Map<int[], Integer> board = new HashMap<>();  //would like for the board to be <position, Player obj>

    //constructor
    public RedLightGreenLight() {
        setLength(length);
        setWidth(width);
        initBoard();
        //fillPlayerList();
        //addPlayers();
    }

    //methods
    public void initBoard() {
        //this zeros out all board positions
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                //Thinking player ID should be replaced with player obj, or could just pull id from player obj
                board.put(initPosition, initPlayerID);
            }
        }
    }

    //using this as dummy holder for player objects
    public void fillPlayerList() {
        for (int i = 1; i < 21; i++) {
            players.add(Integer.valueOf(i));
        }
    }

    //adds players to their starting points on the map
    public void addPlayers() {
        int[] startPosition = {1, 1};
        for (Integer playerID : players) {
            board.put(startPosition , playerID);
            startPosition[0]++;
        }
    }

    //accessors
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "RedLightGreenLight{" +
                "length=" + length +
                ", width=" + width +
                ", players=" + players +
                ", initPosition=" + Arrays.toString(initPosition) +
                ", initPlayerID=" + initPlayerID +
                ", board=" + board +
                '}';
    }*/
}