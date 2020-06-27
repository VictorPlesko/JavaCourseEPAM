package com.plesko.lesson4_1.service;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;

public class ArraySortService {

    public OneDimensionalArray bubbleSort(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public OneDimensionalArray selectionSort(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        for (int i = 0; i < array.size(); i++) {
            int minIndex = i;
            for (int j = i; j < array.size(); j++) {
                if (array.get(j) < array.get(minIndex)) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    public OneDimensionalArray shuttleSort(OneDimensionalArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Null object");
        }
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                swap(array, i, i + 1);
                for (int j = i - 1; j >= 0; j--) {
                    if (array.get(j) > array.get(j + 1)) {
                        swap(array, j, j + 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return array;
    }

    private void swap(OneDimensionalArray array, int index1, int index2) throws CustomException {
        int value = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, value);
    }
}
