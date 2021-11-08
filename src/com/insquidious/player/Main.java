package com.insquidious.player;

public class Main {
    public static void main(String[] args) {
        Player.maxPos = 20;//Max
        ComputerPlayer[] CPU = new ComputerPlayer[19];
        MainPlayer player1 = new MainPlayer("Player1");
        for(int i = 0; i < CPU.length; i++)
        {
            CPU[i] = new ComputerPlayer("CPU"+(i+1));
        }
        for(int i = 0; i < CPU.length; i++)
        {
            int j = Player.boardPositions.indexOf(CPU[i].boardPosition);
            while(Player.boardPositions.indexOf(CPU[i].boardPosition) > -1 && i != j-1)
            {
                //System.out.println("Value od i: "+i+" Value of j: "+j+"\n"+CPU[i].boardPosition+" "+Player.boardPositions.get(j));
                CPU[i] = new ComputerPlayer("CPU"+(i+1));
                Player.boardPositions.set(j,CPU[i].boardPosition);
            }
        }
        for(String Str : Player.boardPositions)
        {
            System.out.println("Position: "+Str);
        }
        System.out.println("Duplicate parts should be gone.");
        Board gameBoard = new Board(new int[20][20]);




    }
    public static int getRandomInteger(int min, int max)
    {
        return ((int)(Math.random()*(max)))+min;
    }
}
