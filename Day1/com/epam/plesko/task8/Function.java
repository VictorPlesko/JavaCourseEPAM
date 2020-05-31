package com.epam.plesko.task8;

/**
 * Class for calculating function value.
 *
 * @author Victor Plesko
 */
public class Function {

    /**
     * Method to calculate the function: F(x) = -x^2 + 3*x + 9, if x >=3
     * 1 / (x^3 - 6), if x < 3
     *
     * @param argument - argument function
     * @return function value
     */
    public double calculate(float argument) {
        return (argument >= 3) ? calculateFirstConditionFunction(argument)
                               : calculateSecondConditionFunction(argument);
    }

    /**
     * Computes the first condition of a function.
     *
     * @param argument - argument function
     * @return function value
     */
    private double calculateFirstConditionFunction(float argument) {
        return -Math.pow(argument, 2) + 3 * argument + 9;
    }

    /**
     * Computes the second condition of a function.
     *
     * @param argument - argument function
     * @return function value
     */
    private double calculateSecondConditionFunction(float argument) {
        return 1 / (Math.pow(argument, 3) - 6);
    }
}
