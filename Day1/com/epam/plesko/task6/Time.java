package com.epam.plesko.task6;

/**
 * Class for finding hours, minutes and seconds by a given number of seconds.
 *
 * @author Victor Plesko
 */
public class Time {

    /**
     * The number of seconds in one hour.
     */
    private final int HOUR_IN_SECOND = 3600;

    /**
     * The number of seconds in one minute.
     */
    private final int MINUTE_IN_SECOND = 60;

    /**
     * Method for displaying the received hours, minutes and seconds.
     *
     * @param second - number of seconds.
     * @return hh:mm:ss format string
     */
    public String getFullTime(int second) {
        if (second >= 0) {
            return getHours(second) + ":" + getMinutes(second) + ":" + getSeconds(second);
        } else {
            throw new IllegalArgumentException("The number of seconds must be non-negative.");
        }
    }

    /**
     * Number of hours in given seconds.
     *
     * @param second - number of seconds
     * @return number of hours
     */
    private int getHours(int second) {
        return second / HOUR_IN_SECOND;
    }

    /**
     * The number of minutes from the specified seconds, taking into account the full hours.
     *
     * @param second - number of seconds
     * @return number of minute
     */
    private int getMinutes(int second) {
        return (second % HOUR_IN_SECOND) / MINUTE_IN_SECOND;
    }

    /**
     * The number of minutes from the specified seconds, taking into account the full hours and minutes.
     *
     * @param second - number of seconds
     * @return number of second
     */
    private int getSeconds(int second) {
        return second % MINUTE_IN_SECOND;
    }
}
