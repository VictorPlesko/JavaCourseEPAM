package com.plesko.lesson3.entity;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Ball> balls = new ArrayList<>();
    private double volume;

    public Basket(double volume) {
        this.volume = volume;
    }

    public boolean add(Ball ball) {
        if (ball == null || (calculateOccupiedVolume() + ball.volume()) > volume) {
            return false;
        }
        return balls.add(ball);
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public int size() {
        return balls.size();
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        boolean equalArray = true;
        if (basket.size() == balls.size()) {
            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).getWeight() != balls.get(i).getWeight()
                        || basket.get(i).getRadius() != balls.get(i).getRadius()
                        || !basket.get(i).getColor().equals(balls.get(i).getColor())) {
                    equalArray = false;
                    break;
                }
            }
        } else {
            equalArray = false;
        }
        return Double.compare(basket.volume, volume) == 0 && equalArray;

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (int) volume;
        result = prime * result + balls.hashCode();
        return result;
    }

    private double calculateOccupiedVolume() {
        double occupiedVolume = 0;
        for (Ball ball : balls) {
            occupiedVolume += ball.volume();
        }
        return occupiedVolume;
    }
}
