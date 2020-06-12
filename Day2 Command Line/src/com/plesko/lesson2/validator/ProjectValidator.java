package com.plesko.lesson2.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProjectValidator {

    private static final int MAX_MONTH = 12;

    public boolean isPositive(int value) {
        return value > 0;
    }

    public boolean checkDay(int days, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month, 1);
        int dayInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days <= dayInMonth;
    }

    public boolean checkMonth(int month) {
        return month > 0 && month <= MAX_MONTH;
    }

    public boolean checkYear(int year) {
        return year > 0;
    }

    public boolean checkDate(int day, int month, int year) {
        Calendar now = Calendar.getInstance();
        if (!checkDay(day, month, year) || !checkMonth(month) || !checkYear(year)){
            return false;
        }
        Calendar given = new GregorianCalendar(year, month, day);
        return now.compareTo(given) > 0;
    }
}
