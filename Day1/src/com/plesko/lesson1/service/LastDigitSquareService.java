package com.plesko.lesson1.service;

public class LastDigitSquareService {

    public int calculateDigit(int number) {
        int lastDigitNumber = number % 10;
        int digitSquareNumber = (int) Math.pow(lastDigitNumber, 2);
        return digitSquareNumber % 10;
    }
}
