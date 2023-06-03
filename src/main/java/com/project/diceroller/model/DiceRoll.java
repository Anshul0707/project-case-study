package com.project.diceroller.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class DiceRoll {

    private int numberOfDice;
    private int numberOfSides;

//    public DiceRoll(int numberOfDice, int numberOfSides) {
//        this.numberOfDice = numberOfDice;
//        this.numberOfSides = numberOfSides;
//    }
}
