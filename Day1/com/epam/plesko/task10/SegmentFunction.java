package com.epam.plesko.task10;

/**
 * A class for calculating the value of a function on the interval [a,b]
 * with step h and its output to the table.
 *
 * @author Victor Plesko
 */
public class SegmentFunction {

    private int startOfSegment;
    private int endOfSegment;
    private double step;

    /**
     * A constructor in which values are assigned to fields with a check for their validity.
     *
     * @param startOfSegment - start of segment
     * @param endOfSegment - end of line
     * @param step - step with which we go along the segment.
     */
    public SegmentFunction(int startOfSegment, int endOfSegment, double step) {
        this.startOfSegment = startOfSegment;
        this.endOfSegment = endOfSegment;
        if (step > 0) {
            this.step = step;
        } else {
            throw new IllegalArgumentException("Step must be positive.");
        }
    }

    /**
     * Calculation of a given function: F(x) = tg(x)
     *
     * @param value - argument value
     * @return function value
     */
    private double calculateFunctionValue(double value){
        return Math.tan(value);
    }

    /**
     * Output of the table to the console,
     * in which the first column is the value of the argument,
     * and the second column is the value of the function.
     */
    public void getTable(){
        System.out.printf("%-20s%-20s\n", "Argument value", "Function value");
        double currentPosition = startOfSegment;
        do{
            System.out.printf("%-20f%-20f\n", currentPosition, calculateFunctionValue(currentPosition));
            currentPosition += step;
        }while (currentPosition <= endOfSegment);
    }
}
