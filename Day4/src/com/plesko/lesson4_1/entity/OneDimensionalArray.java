package com.plesko.lesson4_1.entity;

import com.plesko.lesson4_1.exception.CustomException;

public class OneDimensionalArray {

    private int[] arrayNumber;

    public OneDimensionalArray(int... arrayNumber) throws CustomException {
        if (arrayNumber == null) {
            throw new CustomException("Invalid value.");
        }
        this.arrayNumber = arrayNumber;
    }

    public OneDimensionalArray(int amountElement) throws CustomException {
        if (amountElement < 1) {
            throw new CustomException("Invalid value.");
        }
        arrayNumber = new int[amountElement];
    }

    public int size() {
        return arrayNumber.length;
    }

    public int get(int index) throws CustomException {
        if (!isCorrectIndex(index)) {
            throw new CustomException("Out of bounds array.");
        }
        return arrayNumber[index];
    }

    public boolean set(int index, int newElement) {
        if (isCorrectIndex(index)) {
            arrayNumber[index] = newElement;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneDimensionalArray that = (OneDimensionalArray) o;
        if (arrayNumber.length != that.size()) {
            return false;
        }
        for (int i = 0; i < arrayNumber.length; i++) {
            try {
                if (arrayNumber[i] != that.get(i)) {
                    return false;
                }
            } catch (CustomException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        for (int value : arrayNumber) {
            result = prime * result + value;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OneDimensionalArray: {");
        for (int value : arrayNumber) {
            sb.append(value).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("}");
        return sb.toString();
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < arrayNumber.length;
    }
}
