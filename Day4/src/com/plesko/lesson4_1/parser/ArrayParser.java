package com.plesko.lesson4_1.parser;

public class ArrayParser {

    public int[] parseToIntegerArray(String[] arrayNumber) {
        int[] result = new int[arrayNumber.length];
        for (int i = 0; i < arrayNumber.length; i++) {
            result[i] = Integer.parseInt(arrayNumber[i]);
        }
        return result;
    }
}
