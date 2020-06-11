package com.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.validator.DateAndTimeValidator;

public class TimeService {

    private final int HOUR_IN_SECOND = 3600;
    private final int MINUTE_IN_SECOND = 60;

    public String calculateFullTime(int seconds) throws CustomException {
        DateAndTimeValidator dateAndTimeValidator = new DateAndTimeValidator();
        if (!dateAndTimeValidator.checkSecond(seconds)) {
            throw new CustomException("The number of seconds must be non-negative.");
        }
        int hoursInSeconds = seconds / HOUR_IN_SECOND;
        int minutesInSeconds = (seconds % HOUR_IN_SECOND) / MINUTE_IN_SECOND;
        int secondsInSeconds = seconds % MINUTE_IN_SECOND;
        return String.format("%d:%d:%d", hoursInSeconds ,minutesInSeconds, secondsInSeconds);
    }
}
