package com.plesko.lesson1.console;

public class CustomFunctionColsole {

    public void printSimpleFunctionValue(double value) {
        System.out.printf("The value of the function is %f", value);
    }

    public void printTableTangentFunction(double[][] answer) {
        for (int j = 0; j < answer[0].length; j++) {
            System.out.printf("%-20f \t %-20f", answer[0][j], answer[1][j]);
        }
    }
}
