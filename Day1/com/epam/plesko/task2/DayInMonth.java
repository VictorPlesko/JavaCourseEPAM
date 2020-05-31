package com.epam.plesko.task2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class for finding the number of days for a specified month and year.
 *
 * @author Victor Plesko
 */
public class DayInMonth {

    /**
     * A method available to the user for a call in which additional methods are called.
     *
     * @param month - variable in which the month number is stored.
     * @param year  - variable in which year is stored.
     * @return amount of days
     */
    public int getNumberDays(int month, int year) {
        if (checkDate(month, year)) {
            return findQuantityDays(month, year);
        } else {
            throw new IllegalArgumentException("Invalid value for passed parameters");
        }
    }

    /**
     * Method for checking received month and year.
     *
     * @param month - variable in which the month number is stored.
     * @param year  - variable in which year is stored.
     * @return result of checking
     */
    private boolean checkDate(int month, int year) {
        return (month > 0 && month <= 12) && (year > 0);
    }

    /**
     * The method in which using the Calendar class is the number of days at a given date.
     *
     * @param month - variable in which the month number is stored.
     * @param year  - variable in which year is stored.
     * @return amount of days
     */
    private int findQuantityDays(int month, int year) {
        --month;
        Calendar calendar = new GregorianCalendar(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
