package com.plesko.lesson2.main;

import com.plesko.lesson2.service.ArithmeticArgumentService;

public class ArithmeticArgumentMain {

    public static void main(String[] args) {
        int[] arrayIntArgument = new int[args.length];
        for (int i = 0; i < args.length; i++){
            arrayIntArgument[i] = Integer.parseInt(args[i]);
        }
        ArithmeticArgumentService arithmeticArgumentService = new ArithmeticArgumentService();
        long sum = arithmeticArgumentService.sumElements(arrayIntArgument);
        long multiply = arithmeticArgumentService.multiplyElements(arrayIntArgument);
        System.out.printf("Sum: %d\n", sum);
        System.out.printf("Multiply: %d", multiply);
    }
}
