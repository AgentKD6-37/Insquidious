package com.insquidious.player;


public class ComputerPlayer extends Player{
    String name; //this will get randomly assigned from txt file or other solution


    public ComputerPlayer(String name){
        super(name);
        createPosition();//Place piece on board at start
    };
    public void createPosition()
    {
        for(int i = 0; i < 2; i ++)
        {
            boardPosition +=getRandomInteger(minPos,maxPos);//arguments can be set in parent class constructor
            if(i<2-1)
            {
                boardPosition+=",";
            }
        }
        Player.boardPositions.add(boardPosition);
    }
}