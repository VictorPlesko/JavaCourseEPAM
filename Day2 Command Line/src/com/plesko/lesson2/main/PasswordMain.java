package com.plesko.lesson2.main;

import com.plesko.lesson2.service.PasswordService;

import java.util.Scanner;

public class PasswordMain {

    public static void main(String[] args) {
        if (args.length != 1){
            throw new IllegalArgumentException("Invalid incoming arguments.");
        }
        String sample = args[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String input = scanner.nextLine();
        PasswordService passwordService = new PasswordService();
        if (!passwordService.isCorrectPassword(sample,input)){
            System.out.println("Incorrect password!");
            return;
        }
        System.out.println("Welcome!");
    }
}
