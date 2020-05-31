package com.epam.plesko.task7;

/**
 * Class for finding a point that is closer to the origin.
 *
 * @author Victor Plekso
 */
public class Coordinates {

    /**
     * A method in which distances from the origin to a given point are compared.
     *
     * @param x1 - first point coordinate
     * @param y1 - first point coordinate
     * @param x2 - second point coordinate
     * @param y2 - second point coordinate
     * @return 0 - if the distances are equal. 1- if the first point is closer.
     * -1 - if the second point is closer.
     */
    public int findNearestPoint(int x1, int y1, int x2, int y2){
        double distanceFirstPoint = findDistance(x1,y1);
        double distanceSecondPoint = findDistance(x2,y2);
        if (distanceFirstPoint == distanceSecondPoint){
            return 0;
        } else {
            return (distanceFirstPoint < distanceSecondPoint)
                    ? 1 : -1;
        }
    }

    /**
     * Method that finds the distance from the origin to a given point.
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @return distance to a given point
     */
    private double findDistance(int x, int y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
