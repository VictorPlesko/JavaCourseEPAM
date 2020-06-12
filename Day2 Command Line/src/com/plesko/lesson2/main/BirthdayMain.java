package com.plesko.lesson2.main;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.service.BirthdayService;

public class BirthdayMain {

    public static void main(String[] args) {
        if (args.length != 3){
            throw new IllegalArgumentException("Invalid incoming arguments.");
        }
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        try {
            BirthdayService birthdayService = new BirthdayService();
            String dayOfWeek = birthdayService.findDayOfWeekBirthday(day, month, year);
            System.out.println("Day of the week: " + dayOfWeek);
            if (birthdayService.isBirthdayToday(day, month,year)) {
                System.out.println("Happy Birthday!");
            }
            int fullYear = birthdayService.findNumberOfFullYears(day, month, year);
            System.out.println("Full years: " + fullYear);
        } catch (CustomException ex){
            ex.printStackTrace();
        }
    }
}
