/*
* Dice Rolling Functions
* Author: Justin Hammel
* Description: Methods generate random numbers corresponding to rolling dice.
*           Uses the random library to generate a pseudo-random number based on
*           the number of sides on the dice and number of dice being rolled. Expects
*           2 ints for the sides and number of dice in the dice object.
*           Default to rolling 1, six-sided die.
*/

package com.insquidious.squidgame.util;

import java.util.Random;



public class Dice {
    //fields
    private int sides = 6;
    private int numDice = 1;

    //methods

    /*
     * Uses the random library to generate a pseudo-random number based on the number
     * of sides on the dice passed to the function. Function expects to pull 1 int from
     * getSides() to bound the die roll. Can be used on it's own to generate a random die
     * roll, or in combination with dieSum to tally multiple rolls.
     */
    public int roll() {
        int result = 0;
        sides = getSides() + 1;
        Random random = new Random();   //instance of the random number class
        result = (random.nextInt(sides) + 1);   //generates random number from 1-sides
        return result;
    }

    public int dieSum() {
        int sum = 0;
        for (int i = 0; i < getNumDice(); i++) {
            sum = sum + this.roll();
        }
        return sum;
    }

    //constructors
    public Dice(){};

    public Dice(int sides) {
        setSides(sides);
    }

    public Dice(int sides, int numDice) {
        setSides(sides);
        setNumDice(numDice);
    }

    //accessors
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getNumDice() {
        return numDice;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
    }
}