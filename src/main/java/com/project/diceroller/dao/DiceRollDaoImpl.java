package com.project.diceroller.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DiceRollDaoImpl implements DiceRollDao{
    private static final int[] SUPPORTED_SIDES = {4, 6, 8, 10, 12, 20};

    @Override
    public boolean isSupportedNumberOfSides(int numberOfSides) {
        for (int supportedSides : SUPPORTED_SIDES) {
            if (numberOfSides == supportedSides) {
                return true;
            }
        }
        return false;
    }
}
