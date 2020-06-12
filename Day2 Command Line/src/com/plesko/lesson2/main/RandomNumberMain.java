package com.plesko.lesson2.main;

import com.plesko.lesson2.exception.CustomException;
import com.plesko.lesson2.service.RandomNumberService;

public class RandomNumberMain {

    public static void main(String[] args) {
        if (args.length != 1){
            throw new IllegalArgumentException("Invalid incoming arguments.");
        }
        int count = Integer.parseInt(args[0]);
        RandomNumberService randomNumberService = new RandomNumberService();
        try {
            int[] answer = randomNumberService.randomNumbers(count);
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i : answer) {
                System.out.println(i);
            }
        } catch (CustomException ex) {
            ex.printStackTrace();
        }
    }
}
