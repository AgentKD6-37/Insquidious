package com.insquidious.squidgame.board;

public class BoardFactory {

    public static Board createBoard(BoardType game) {
        Board board = null;

        switch (game) {
            case RLGL:
                board = new RedLightGreenLight();
                break;

            case DALGANO:
                board = new Dalgano();
                break;

            default:
                //throw an exception
                System.out.println("Invalid board type, must be RLGL, or DALGANO");
        }
        return board;
    }
}