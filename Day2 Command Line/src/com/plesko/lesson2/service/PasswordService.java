package com.plesko.lesson2.service;

public class PasswordService {

    public boolean isCorrectPassword(String sample, String input){
        return input.equals(sample);
    }
}
