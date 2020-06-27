package com.plesko.lesson4_1.validator;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;

public class ArrayValidator {

    public boolean isSorted(OneDimensionalArray array) throws CustomException {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
