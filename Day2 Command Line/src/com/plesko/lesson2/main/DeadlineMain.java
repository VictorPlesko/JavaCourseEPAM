package com.plesko.lesson2.main;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.service.DeadlineService;

public class DeadlineMain {

    public static void main(String[] args) {
        if (args.length != 2){
            throw new IllegalArgumentException("Invalid incoming arguments.");
        }
        String name = args[0];
        int amountOfDays = Integer.parseInt(args[1]);
        DeadlineService deadlineService = new DeadlineService();
        try {
            String date = deadlineService.calculateDeadline(amountOfDays);
            System.out.format("Name: %s \nDeadline: %s", name, date);
        } catch (CustomException ex) {
            ex.printStackTrace();
        }
    }
}
