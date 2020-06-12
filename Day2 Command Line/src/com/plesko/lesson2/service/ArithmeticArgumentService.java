package com.plesko.lesson2.service;

public class ArithmeticArgumentService {

    public long sumElements(int[] array){
        long result = 0;
        for (int value : array) {
            result += value;
        }
        return result;
    }

    public long multiplyElements(int[] array){
        long result = 1;
        for (int value : array) {
            result *= value;
        }
        return result;
    }
}
