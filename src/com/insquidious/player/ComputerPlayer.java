package com.insquidious.player;


import java.util.Random;

public class ComputerPlayer extends Player{
    private static final int MAX_SPEED = 4;

    public ComputerPlayer(String playerName){
        super(playerName);
        setPlayerSpd(playerSpd);
    };

    private int generateRandomSpeed( int MAX_SPEED){
        Random randomSpeed = new Random();
        return playerSpd = randomSpeed.nextInt(MAX_SPEED);
    }


    @Override
    public int getPlayerSpd() {
        return playerSpd;
    }

    @Override
    public void setPlayerSpd(int playerSpd) {
        this.playerSpd = generateRandomSpeed(MAX_SPEED);
    }

    @Override
    public String toString() {
        return "ComputerPlayer{" +
                "maxSpeed=" + MAX_SPEED +
                ", isAlive=" + isAlive +
                ", playerName='" + playerName + '\'' +
                ", playerSpd=" + playerSpd +
                ", playerDist=" + playerDist +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}