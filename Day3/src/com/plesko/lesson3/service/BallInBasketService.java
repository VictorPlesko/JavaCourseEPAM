package com.plesko.lesson3.service;

import com.plesko.lesson3.entity.Basket;
import com.plesko.lesson3.entity.BallColor;
import com.plesko.lesson3.exception.CustomException;

public class BallInBasketService {

    public double calculateWeightInBasket(Basket basket) throws CustomException {
        if (basket == null) {
            throw new CustomException("Invalid function parameter");
        }
        double weight = 0;
        for (int i = 0; i < basket.size(); i++) {
            weight += basket.get(i).getWeight();
        }
        return weight;
    }

    public int findNumberBallsByColor(Basket basket, BallColor ballColor) throws CustomException {
        if (basket == null || ballColor == null) {
            throw new CustomException("Invalid function parameter");
        }
        int count = 0;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).getColor().equals(ballColor)) {
                count++;
            }
        }
        return count;
    }
}
