package com.insquidious.player;

public class Main {
    public static void main(String[] args) {
        Player.maxPos = 20;
        String name="";
        for(int i = 0; i < 2; i ++)
        {
            name +=getRandomInteger(0,5);//arguments can be set in parent class contructor
            if(i<2-1)
            {
                name+=",";
            }
        }
        System.out.println(name);
    }
    public static int getRandomInteger(int min, int max)
    {
        return ((int)(Math.random()*(max)))+min;
    }
}
