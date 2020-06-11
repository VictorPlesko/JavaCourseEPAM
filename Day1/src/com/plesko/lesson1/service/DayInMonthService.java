package com.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.DateAndTimeValidator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayInMonthService {

    public int findNumberDays(int month, int year) throws CustomException {
        DateAndTimeValidator dateValidator = new DateAndTimeValidator();
        if (!dateValidator.checkYear(year) || !dateValidator.checkMonth(month)) {
            throw new CustomException("Invalid value for passed parameters");
        }
        return findQuantityDays(month, year);
    }

    private int findQuantityDays(int month, int year) {
        --month;
        Calendar calendar = new GregorianCalendar(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
