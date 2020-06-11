package com.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.NumericalValidator;

public class GeometricService {

    public double calculateAreaInscribedSquare(double outerSquare) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(outerSquare)) {
            throw new CustomException("The value of the area must be positive.");
        }
        return outerSquare / 2;
    }

    public double calculateSquareDifference(double outerSquare, double inscribedSquare) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(outerSquare) || !numericalValidator.isPositive(inscribedSquare)) {
            throw new CustomException("The value of the area must be positive.");
        }
        return outerSquare / inscribedSquare;
    }

    public double calculateCircumference(double radius) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(radius)) {
            throw new CustomException("Radius must be positive.");
        }
        return 2 * Math.PI * radius;
    }

    public double calculateCircleArea(double radius) throws CustomException {
        NumericalValidator numericalValidator = new NumericalValidator();
        if (!numericalValidator.isPositive(radius)) {
            throw new CustomException("Radius must be positive.");
        }
        return Math.PI * Math.pow(radius, 2);
    }
}
