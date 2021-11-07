package com.insquidious.player;

public abstract class Player {
    //fields
    protected boolean isAlive;//No need in constructor because every player is alive
    protected String boardPosition;//Will be set by a random number gen
    protected String name;
    protected int minPos;
    public static int maxPos;
    public Player(String id, String name)
    {
        minPos = 0;
        isAlive = true;
        this.boardPosition = id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(String boardPosition) {
        this.boardPosition = boardPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getRandomInteger(int min, int max)
    {
        return ((int)(Math.random()*(max)))+min;
    }


}