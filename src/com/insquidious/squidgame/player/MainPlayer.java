package com.insquidious.squidgame.player;

public class MainPlayer extends Player{
    private int attributePoints = 3; //start with 3 (will increase with additional stats/games)

    //ctor
    public MainPlayer(String playerName, int playerSpd){

        super(playerName, playerSpd);
        this.attributePoints = getAttributePoints();
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    @Override
    public String toString() {
        return "MainPlayer{" +
                "attributePoints=" + attributePoints +
                ", isAlive=" + isAlive +
                ", playerName='" + playerName + '\'' +
                ", playerSpd=" + playerSpd +
                ", playerDist=" + playerDist +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}