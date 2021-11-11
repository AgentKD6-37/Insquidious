package com.insquidious.squidgame.player;

import java.util.Random;

public class ComputerPlayer extends Player{
    private static final int MAX_SPEED = 5;
    private static final int MIN_SPEED = 2;

    public ComputerPlayer(String playerName){
        super(playerName);
        setPlayerSpd(playerSpd);
    };

    private int generateRandomSpeed( int MIN_SPEED, int MAX_SPEED){
        Random randomSpeed = new Random();
        return playerSpd = randomSpeed.nextInt(MAX_SPEED - MIN_SPEED) + MIN_SPEED;
    }


    @Override
    public int getPlayerSpd() {
        return playerSpd;
    }

    @Override
    public void setPlayerSpd(int playerSpd) {
        this.playerSpd = generateRandomSpeed(MIN_SPEED, MAX_SPEED);
    }

    @Override
    public String toString() {
        return "ComputerPlayer{" +
                "maxSpeed=" + MAX_SPEED +
                ", isAlive=" + isAlive +
                ", playerName='" + playerName +
                ", playerSpd=" + playerSpd +
                ", playerDist=" + playerDist +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}