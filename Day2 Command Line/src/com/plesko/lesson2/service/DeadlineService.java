package com.plesko.lesson2.service;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.validator.ProjectValidator;

import java.util.Calendar;

public class DeadlineService {

    public String calculateDeadline(int days) throws CustomException {
        ProjectValidator projectValidator = new ProjectValidator();
        if (!projectValidator.isPositive(days)) {
            throw new CustomException("Number must be positive!");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        String dateAndTime = String.format("%d.%d.%d %d:%d:%d", calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR), calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return dateAndTime;
    }
}
