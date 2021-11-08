package com.insquidious.player;

public class Board {
    public int[][] board;
    public Board(int[][] board)
    {
        this.board = board;
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                board[i][j] = 0;
            }
        }
    }

    public void showboard()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                System.out.println(board[i][j]);
            }
        }
    }
}
