package com.plesko.lesson1.service;

import com.plesko.lesson1.entity.Point;
import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.PointValidator;

public class CoordinateService {

    public int findNearestPoint(Point point1, Point point2) throws CustomException {
        PointValidator pointValidator = new PointValidator();
        if (!pointValidator.checkPoint(point1) || !pointValidator.checkPoint(point2)) {
            throw new CustomException("Invalid value for passed parameters");
        }
        double distancePoint1 = Math.hypot(point1.getX(), point1.getY());
        double distancePoint2 = Math.hypot(point2.getX(), point2.getY());
        if (distancePoint1 == distancePoint2) {
            return 0;
        }
        return (distancePoint1 < distancePoint2) ? 1 : -1;
    }
}
