package com.plesko.lesson4_1.service;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.validator.ArrayValidator;

import java.util.ArrayList;

public class SearchElementArrayService {

    public int binarySearch(OneDimensionalArray sortedArray, int value) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (sortedArray == null || !arrayValidator.isSorted(sortedArray)) {
            throw new CustomException("Invalid array");
        }
        int low = 0;
        int high = sortedArray.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (value > sortedArray.get(middle)) {
                low = middle + 1;
            } else if (value < sortedArray.get(middle)) {
                high = middle - 1;
            } else if (value == sortedArray.get(middle)) {
                return middle;
            }
        }
        return -1;
    }

    public int maxValue(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    public int minValue(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }

    public OneDimensionalArray findPrimeNumber(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (isPrime(Math.abs(array.get(i)))) {
                primeNumbers.add(array.get(i));
            }
        }
        return toOneDimensionalArray(primeNumbers);
    }

    public OneDimensionalArray findFibonacciNumber(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (isFibonacci(array.get(i))) {
                fibonacciNumbers.add(array.get(i));
            }
        }
        return toOneDimensionalArray(fibonacciNumbers);
    }

    public OneDimensionalArray findNumberWithoutRepeatingNumbers(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (isWithoutRepeatingNumbers(Math.abs(array.get(i)))) {
                uniqueNumbers.add(array.get(i));
            }
        }
        return toOneDimensionalArray(uniqueNumbers);
    }

    private boolean isWithoutRepeatingNumbers(int value) {
        if (value < 100 || value > 999) {
            return false;
        }
        int first = value % 10;
        int second = (value / 10) % 10;
        int third = value / 100;
        return first != second && first != third && second != third;
    }

    private boolean isPrime(int value) {
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isFibonacci(int value) {
        if (value < 1) {
            return false;
        }
        ArrayList<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(1);
        fibonacciSequence.add(1);
        int newFibonacciNumber = 1;
        int i = 1;
        while (newFibonacciNumber < value) {
            newFibonacciNumber = fibonacciSequence.get(i) + fibonacciSequence.get(i - 1);
            fibonacciSequence.add(newFibonacciNumber);
            i++;
        }
        return fibonacciSequence.get(i) == value;
    }

    private OneDimensionalArray toOneDimensionalArray(ArrayList<Integer> array) throws CustomException {
        OneDimensionalArray result = new OneDimensionalArray(array.size());
        for (int i = 0; i < array.size(); i++) {
            result.set(i, array.get(i));
        }
        return result;
    }
}
