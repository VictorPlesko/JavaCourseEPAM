package com.epam.plesko.task3;

/**
 * Class for finding the area of a square inscribed in a circle.
 * And how many times the square areas differ from each other.
 *
 * @author Victor Plesko
 */
public class SquareArea {

    private double outerSquare;
    private  double inscribedSquare;

    /**
     * The constructor of assigning the valid area of the outer square to the field.
     *
     * @param outerSquare - square outer square
     */
    public SquareArea(double outerSquare) {
        if (outerSquare > 0) {
            this.outerSquare = outerSquare;
        } else {
            throw new IllegalArgumentException("The value of the area must be positive.");
        }
    }

    /**
     *  Getting the area of the inscribed square.
     *
     * @return square of the inscribed square.
     */
    public double getAreaInscribedSquare(){
        inscribedSquare = outerSquare / 2;
        return inscribedSquare;
    }

    /**
     * Method showing how many times the area of the inscribed square is less than the external squared.
     *
     * @return square difference.
     */
    public double getSquareDifference(){
        return outerSquare / inscribedSquare;
    }
}
