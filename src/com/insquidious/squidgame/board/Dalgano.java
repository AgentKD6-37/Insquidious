package com.insquidious.squidgame.board;

public class Dalgano extends Board{
    //static fields
    //TODO: change these to reflect the actual game(copied from RLGL)
    public static final int LENGTH = 100;
    public static final int WIDTH = 20;

    Dalgano() {
        super(BoardType.DALGANO, LENGTH, WIDTH);
        initBoard();
    }

    @Override
    protected void initBoard() {
        System.out.println("Creating Dalgano board.");
    }
}