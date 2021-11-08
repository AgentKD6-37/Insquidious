package com.insquidious.squidgame.board;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {
    //fields
    private BoardType game = null;
    private int length;
    private int width;

    public Board(BoardType game, int length, int width) {
        setGame(game);
        setLength(length);
        setWidth(width);
    }

    //perform 1 time processing here

    //subclass level processing
    protected abstract void initBoard();
    protected abstract void drawBoard();

    //Accessors
    public BoardType getGame() {
        return game;
    }

    public void setGame(BoardType game) {
        this.game = game;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}