package com.epam.plesko.task9;

/**
 * Class for finding the area of a circle and the circumference.
 *
 * @author Victor Plesko
 */
public class Circle {

    private float radius;

    /**
     * Radius assignment constructor with positivity check.
     *
     * @param radius - circle radius
     */
    public Circle(float radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be positive.");
        }
    }

    /**
     * Method for calculating the circumference
     *
     * @return circumference
     */
    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    /**
     * Circle area calculation method
     *
     * @return area of a circle
     */
    public double getCircleArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
