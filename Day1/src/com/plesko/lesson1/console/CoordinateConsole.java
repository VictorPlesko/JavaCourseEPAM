package com.plesko.lesson1.console;

import com.plesko.lesson1.entity.Point;

public class CoordinateConsole {

    public void printNearestPoint(Point point1, Point point2, int answer) {
        if (answer == 1) {
            System.out.println(point1);
        } else if (answer == -1) {
            System.out.println(point2);
        } else {
            System.out.println(point1 + " = " + point2);
        }
    }
}
