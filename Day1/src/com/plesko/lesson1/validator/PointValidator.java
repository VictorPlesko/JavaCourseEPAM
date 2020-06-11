package com.plesko.lesson1.validator;

import com.plesko.lesson1.entity.Point;

public class PointValidator {
    private static final double MAX_X_VALUE = 100;
    private static final double MIN_X_VALUE = -100;
    private static final double MAX_Y_VALUE = 100;
    private static final double MIN_Y_VALUE = -100;

    public boolean checkPoint(Point point){
        int x = point.getX();
        int y = point.getY();
        return x >= MIN_X_VALUE && x <= MAX_X_VALUE
                && y >= MIN_Y_VALUE && y <= MAX_Y_VALUE;
    }
}
