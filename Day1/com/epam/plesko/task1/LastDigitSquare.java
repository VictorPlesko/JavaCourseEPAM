package com.epam.plesko.task1;

/**
 * A class for finding the last digit of a square from the last digit of a number.
 *
 * @author Victor Plesko
 */
public class LastDigitSquare {

    /**
     * Method for finding the square of the last digit.
     *
     * @param number is an integer whose last digit will get the last digit of the square
     * @return the last digit of the square
     */
    public int getDigit(int number) {
        int lastDigitNumber = getLastDigit(number);
        return getLastDigit((int) Math.pow(lastDigitNumber, 2));
    }

    /**
     * Method that finds the last digit of a number.
     *
     * @param number - integer which we will find the last digit
     * @return the last digit of the number
     */
    private int getLastDigit(int number) {
        return number % 10;
    }
}
