package com.insquidious.player;

public class ComputerPlayer {
    String name; //this will get randomly assigned from txt file or other solution


    public ComputerPlayer(String name){
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