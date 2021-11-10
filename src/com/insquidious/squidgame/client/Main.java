package com.insquidious.squidgame.client;

import com.insquidious.squidgame.GameEngine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        GameEngine game = new GameEngine();
        game.execute();
    }
}