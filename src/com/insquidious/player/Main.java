package com.insquidious.player;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ComputerPlayer testPlayer = new ComputerPlayer("Yayo");
        System.out.println(testPlayer);

        MainPlayer testPlayer2 = new MainPlayer("Pipo", 5);
        System.out.println(testPlayer2);
    }

}
