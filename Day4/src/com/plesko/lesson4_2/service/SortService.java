package com.plesko.lesson4_2.service;

import com.plesko.lesson4_1.exception.CustomException;

public class SortService {

    public int[][] sortBySumRowElements(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] sum = sumOfRowElements(jaggedArray);
        return bubbleSort(jaggedArray, sum);
    }

    public int[][] reverseSortBySumRowElements(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] sum = sumOfRowElements(jaggedArray);
        return reverse(bubbleSort(jaggedArray, sum));
    }

    public int[][] sortByMaximumRowElement(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] max = maxOfRowElement(jaggedArray);
        return bubbleSort(jaggedArray, max);
    }

    public int[][] reverseSortByMaximumRowElement(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] max = maxOfRowElement(jaggedArray);
        return reverse(bubbleSort(jaggedArray, max));
    }

    public int[][] sortByMinimumRowElement(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] min = minOfRowElement(jaggedArray);
        return bubbleSort(jaggedArray, min);
    }

    public int[][] reverseSortByMinimumRowElement(int[][] jaggedArray) throws CustomException {
        if (jaggedArray == null) {
            throw new CustomException("Null object.");
        }
        int[] min = minOfRowElement(jaggedArray);
        return reverse(bubbleSort(jaggedArray, min));
    }

    private int[][] reverse(int[][] array) {
        int[][] result = new int[array.length][0];
        for (int i = array.length - 1; i >= 0; i--) {
            result[Math.abs(i - array.length + 1)] = array[i];
        }
        return result;
    }

    private int[] maxOfRowElement(int[][] jaggedArray) {
        int[] arrayMaxRow = new int[jaggedArray.length];
        for (int i = 0; i < jaggedArray.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (jaggedArray[i][j] > max) {
                    max = jaggedArray[i][j];
                }
            }
            arrayMaxRow[i] = max;
        }
        return arrayMaxRow;
    }

    private int[] minOfRowElement(int[][] jaggedArray) {
        int[] arrayMinRow = new int[jaggedArray.length];
        for (int i = 0; i < jaggedArray.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (jaggedArray[i][j] < min) {
                    min = jaggedArray[i][j];
                }
            }
            arrayMinRow[i] = min;
        }
        return arrayMinRow;
    }

    private int[] sumOfRowElements(int[][] jaggedArray) {
        int[] arraySumRow = new int[jaggedArray.length];
        for (int i = 0; i < jaggedArray.length; i++) {
            int sum = 0;
            for (int j = 0; j < jaggedArray[i].length; j++) {
                sum += jaggedArray[i][j];
            }
            arraySumRow[i] = sum;
        }
        return arraySumRow;
    }

    private int[][] bubbleSort(int[][] jaggedArray, int[] settingsArray) {
        for (int i = 0; i < settingsArray.length; i++) {
            for (int j = 0; j < settingsArray.length - 1; j++) {
                if (settingsArray[j] > settingsArray[j + 1]) {
                    swap(settingsArray, j, j + 1);
                    swap(jaggedArray, j, j + 1);
                }
            }
        }
        return jaggedArray;
    }

    private void swap(int[] array, int temp1, int temp2) {
        int item = array[temp1];
        array[temp1] = array[temp2];
        array[temp2] = item;
    }

    private void swap(int[][] array, int temp1, int temp2) {
        int[] item = array[temp1];
        array[temp1] = array[temp2];
        array[temp2] = item;
    }
}
