package com.epam.plesko.task5;

/**
 * Class for determining perfect numbers.
 *
 * @author Victor Plesko
 */
public class PerfectNumber {

    /**
     * Method for checking if a given number is perfect.
     *
     * @param number - checked number
     * @return true - if the number is perfect, otherwise - false
     */
    public boolean isPerfectNumber(int number) {
        if (isPositive(number)) {
            return number == getSumDividers(number);
        } else {
            throw new IllegalArgumentException("The number must be positive.");
        }
    }

    /**
     * Checking the number to be positive.
     *
     * @param number - checked number
     * @return true - if positive, otherwise - false
     */
    private boolean isPositive(int number) {
        return number > 0;
    }

    /**
     * Method for finding the sum of dividers.
     *
     * @param number - the number for which the sum of the divisors is calculated
     * @return sum of dividers
     */
    private int getSumDividers(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if ((number % i) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
