package com.insquidious.player;

import java.util.Random;

public class MainPlayer extends Player{
    private int speed = 0;
    // possibly strength and intelligence
    private int attributePoints = 3; //start with 3 (will increase with additional stats/games)

    //ctor
    public MainPlayer(String name){
        super(name,"");
        createPosition();//Place piece on board at start
    };
    private void createPosition()
    {
        for(int i = 0; i < 2; i ++)
        {
            name +=getRandomInteger(minPos,maxPos);//arguments can be set in parent class contructor
            if(i<2-1)
            {
                name+=",";
            }
        }
    }
}
