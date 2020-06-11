package com.plesko.lesson1.service;

public class EvenNumberService {

    public boolean isTwoAndMoreEvenNumbers(int firstNumber, int secondNumber,
                                           int thirdNumber, int fourthNumber) {
        int counterEvenNumber = 0;
        int[] arrayParameters = {firstNumber, secondNumber, thirdNumber, fourthNumber};
        for (int number : arrayParameters) {
            if ((number % 2) == 0) {
                ++counterEvenNumber;
            }
        }
        return counterEvenNumber >= 2;
    }
}
