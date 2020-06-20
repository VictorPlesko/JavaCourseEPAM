package com.plesko.lesson3.entity;

import com.plesko.lesson3.exception.CustomException;

public class Ball {

    private double weight;
    private double radius;
    private ColorBall color;

    public Ball(int weight, double radius, ColorBall color) throws CustomException {
        if (weight <= 0 || radius <= 0 || color == null) {
            throw new CustomException("Invalid parameter");
        }
        this.weight = weight;
        this.radius = radius;
        this.color = color;
    }

    public double volume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    public double getWeight() {
        return weight;
    }

    public ColorBall getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return weight == ball.weight &&
                Double.compare(ball.radius, radius) == 0 &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (int) weight;
        result = prime * result + (int) radius;
        result = prime * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball: ");
        sb.append("weight = ").append(weight);
        sb.append(", color = ").append(color);
        sb.append(", radius = ").append(radius);
        return sb.toString();
    }
}
