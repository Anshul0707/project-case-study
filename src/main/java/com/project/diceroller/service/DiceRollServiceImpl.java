package com.project.diceroller.service;

import com.project.diceroller.dao.DiceRollDao;
import com.project.diceroller.dao.DiceRollDaoImpl;
import com.project.diceroller.exceptions.DiceServiceException;
import com.project.diceroller.model.DiceRoll;
import com.project.diceroller.utils.RandomDiceGenerator;
import org.springframework.stereotype.Service;

@Service
public class DiceRollServiceImpl implements DiceRollService{

    private DiceRollDao diceRollDao;
    private DiceRoll diceRoll;
    private DiceRollDaoImpl diceRollDaoImpl;
    private RandomDiceGenerator randomDiceGenerator;

    public DiceRollServiceImpl(DiceRollDao diceRollDao, DiceRoll diceRoll, DiceRollDaoImpl diceRollDaoImpl, RandomDiceGenerator randomDiceGenerator) {
        this.diceRollDao = diceRollDao;
        this.diceRoll = diceRoll;
        this.diceRollDaoImpl = diceRollDaoImpl;
        this.randomDiceGenerator = randomDiceGenerator;
    }


    @Override
    public int arithmeticExpression(String expression) throws DiceServiceException {

        int finalOutput=0;
        String[] splitExpression = expression.split("[+-]");
        for (String oneExpression : splitExpression) {
            String singleExpression = oneExpression.trim();
            System.out.println(singleExpression);
            String[] numericalSplit = singleExpression.split("[Dd]");
            int numberOfDice = Integer.parseInt(numericalSplit[0]);
            int numberOfSides = Integer.parseInt(numericalSplit[1]);

            if (diceRollDaoImpl.isSupportedNumberOfSides(numberOfSides)){
//                diceRoll.setNumberOfDice(numberOfDice);
//                diceRoll.setNumberOfSides(numberOfSides);
                finalOutput = randomDiceGenerator.roll(numberOfDice, numberOfSides);
            }
            else {
                System.out.println(numberOfSides+"Sided dice are not supported");
            }


        }
        return finalOutput;
    }

    public static void main(String[] args) {
        int finalOutput=0;
        String expression="4D6 +       1D4";
        String[] splitExpression = expression.split("[+-]");
        for (String oneExpression : splitExpression) {
            String singleExpression = oneExpression.trim();
//            System.out.println(singleExpression);
            String[] numericalSplit = singleExpression.split("[Dd]");
            int numberOfDice = Integer.parseInt(numericalSplit[0]);
            int numberOfSides = Integer.parseInt(numericalSplit[1]);
            DiceRollDaoImpl diceRollDao1 = new DiceRollDaoImpl();
            RandomDiceGenerator diceGenerator=new RandomDiceGenerator();

            if (diceRollDao1.isSupportedNumberOfSides(numberOfSides)){
//                diceRoll.setNumberOfDice(numberOfDice);
//                diceRoll.setNumberOfSides(numberOfSides);
                finalOutput = diceGenerator.roll(numberOfDice, numberOfSides);
            }
            else {
                System.out.println(numberOfSides+"Sided dice are not supported");
            }

            System.out.println(finalOutput);
//            System.out.println("NumberOfDice: "+numberOfDice);
//            System.out.println("NumberOfSides: "+numberOfSides);
//            System.out.println("______________");
        }
    }
}
