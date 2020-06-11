package com.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.NumericalValidator;

public class CustomFunctionService {

    public double[][] calculateTangentFunction(int startOfSegment,
                                               int endOfSegment,
                                               double step) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(step)) {
            throw new CustomException("The step must be positive");
        }
        int numberOfFunctionValue = (int) ((endOfSegment - startOfSegment) / step) + 1;
        double[][] functionValue = new double[2][numberOfFunctionValue];
        double currentPosition = startOfSegment;
        int positionInArray = 0;
        do {
            functionValue[0][positionInArray] = currentPosition;
            functionValue[1][positionInArray] = Math.tan(currentPosition);
            currentPosition += step;
            ++positionInArray;
        } while (currentPosition <= endOfSegment);
        return functionValue;
    }

    public double calculateSimpleFunction(double argument) {
        return (argument >= 3)
                ? -Math.pow(argument, 2) + 3 * argument + 9
                : 1 / (Math.pow(argument, 3) - 6);
    }
}
