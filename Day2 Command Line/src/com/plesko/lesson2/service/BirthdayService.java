package com.plesko.lesson2.service;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.validator.ProjectValidator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BirthdayService {

    public String findDayOfWeekBirthday(int day, int month, int year) throws CustomException {
        ProjectValidator projectValidator = new ProjectValidator();
        if (!projectValidator.checkDate(day,month,year)){
            throw new CustomException("Invalid date.");
        }
        --month;
        Calendar calendar = new GregorianCalendar(year, month, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        String nameOfDay = dateFormat.format(calendar.getTime());
        return nameOfDay;
    }

    public boolean isBirthdayToday(int day, int month, int year) throws CustomException {
        ProjectValidator projectValidator = new ProjectValidator();
        if (!projectValidator.checkDate(day,month,year)){
            throw new CustomException("Invalid date.");
        }
        Calendar calendar = Calendar.getInstance();
        int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
        int monthNow = calendar.get(Calendar.MONTH) + 1;
        return day == dayNow && month == monthNow;
    }

    public int findNumberOfFullYears(int day, int month, int year) throws CustomException {
        ProjectValidator projectValidator = new ProjectValidator();
        if (!projectValidator.checkDate(day,month,year)){
            throw new CustomException("Invalid date.");
        }
        --month;
        Calendar birthday = new GregorianCalendar(year, month, day);
        Calendar now = Calendar.getInstance();
        int age = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) <= birthday.get(Calendar.DAY_OF_YEAR)) {
            --age;
        }
        return age;
    }
}
