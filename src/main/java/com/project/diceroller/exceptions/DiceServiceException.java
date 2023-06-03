package com.project.diceroller.exceptions;

public class DiceServiceException extends Exception {

    public DiceServiceException(Exception ex) {
        super(ex);
    }

    public DiceServiceException(String message) {
        super(message);
    }

    public DiceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
