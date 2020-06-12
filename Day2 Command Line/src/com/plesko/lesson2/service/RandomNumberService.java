package com.plesko.lesson2.service;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.validator.ProjectValidator;

import java.util.Random;

public class RandomNumberService {

    public int[] randomNumbers(int count) throws CustomException {
        ProjectValidator projectValidator = new ProjectValidator();
        if (!projectValidator.isPositive(count)){
            throw new CustomException("Number must be positive.");
        }
        Random random = new Random();
        int [] answer = new int[count];
        for (int i = 0; i < count; i++){
            answer[i] = random.nextInt();
        }
        return answer;
    }
}
