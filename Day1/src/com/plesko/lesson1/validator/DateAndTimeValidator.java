package com.plesko.lesson1.validator;

public class DateAndTimeValidator {

    private static final int MAX_MONTH = 12;
    private static final int SECONDS_IN_DAY = 86400;

    public boolean checkMonth(int month) {
        return month > 0 && month <= MAX_MONTH;
    }

    public boolean checkYear(int year) {
        return year > 0;
    }

    public boolean checkSecond(int second) {
        return second > 0 && second <= SECONDS_IN_DAY;
    }
}
