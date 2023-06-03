package com.project.diceroller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomDiceGenerator {

    private int numberOfDice;
    private int numberOfSides;

//    int numberOfDice=diceRoll.getNumberOfDice();
//    int numberOfSides=diceRoll.getNumberOfSides();

//    int numberOfDice=4;
//    int numberOfSides=6;

    public int roll(int numberOfDice,int numberOfSides) {
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < numberOfDice; i++) {
            sum += random.nextInt(numberOfSides);
        }
        return sum;
    }


    public static void main(String[] args) {
            int numberOfDice=4;
            int numberOfSides=6;
        RandomDiceGenerator randomDiceGenerator=new RandomDiceGenerator();
        System.out.println(randomDiceGenerator.roll(numberOfDice,numberOfSides ));
    }
}
