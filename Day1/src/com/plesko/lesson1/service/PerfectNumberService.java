package com.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.NumericalValidator;

public class PerfectNumberService {

    public boolean isPerfectNumber(int number) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(number)) {
            throw new CustomException("The number must be positive.");
        }
        return number == calculateSumDividers(number);
    }

    private int calculateSumDividers(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if ((number % i) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
