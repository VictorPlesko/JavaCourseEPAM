package com.epam.plesko.task4;

/**
 * A class for finding even numbers among given four.
 *
 * @author Victor Plesko
 */
public class EvenNumbers {

    /**
     * The method of counting even numbers among the parameters of the method.
     *
     * @param firstNumber  - number to check
     * @param secondNumber - number to check
     * @param thirdNumber  - number to check
     * @param fourthNumber - number to check
     * @return true - if there are two or more even numbers, otherwise - false.
     */
    public boolean isTwoEvenNumbers(int firstNumber, int secondNumber,
                                    int thirdNumber, int fourthNumber) {
        int counterEvenNumber = 0;
        int[] arrayParameters = {firstNumber, secondNumber, thirdNumber, fourthNumber};
        for (int number : arrayParameters) {
            if (isEven(number)) {
                ++counterEvenNumber;
            }
        }
        return counterEvenNumber >= 2;
    }

    /**
     * Method for determining the parity of a number.
     *
     * @param number - checked number.
     * @return true - if even, false - if not even.
     */
    private boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
