package com.insquidious.player;

import com.insquidious.helpers.Dice;

public abstract class Player {
    //fields
    protected boolean isAlive;//No need in constructor because every player is alive
    protected String playerName;
    protected int playerSpd;
    protected int playerDist = 0;
    protected int yCoordinate = 0;
    protected int playerID;
    Dice d20 = new Dice(20);

    public Player(String playerName)
    {
        isAlive = true;
        this.playerName = playerName;
        this.playerSpd = getPlayerSpd();
    }

    public Player(String playerName, int playerSpd)
    {
        isAlive = true;
        this.playerName = playerName;
        this.playerSpd = 0;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerSpd() {
        return playerSpd;
    }

    public void setPlayerSpd(int playerSpd) {
        this.playerSpd = playerSpd;
    }

    public void setPlayerID(){
       playerID = d20.dieRoller();
    }

    public int getPlayerID(){
        return playerID;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}