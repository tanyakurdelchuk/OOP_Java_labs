package org.example.candies.exceptions;

public class NegativeSugarAmountException extends Throwable {
    public NegativeSugarAmountException(String message) {
        super(message);
    }
}
