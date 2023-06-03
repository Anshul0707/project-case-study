package com.project.diceroller.service;

import com.project.diceroller.exceptions.DiceServiceException;

public interface DiceRollService {
    int arithmeticExpression(String expression) throws DiceServiceException;
}
