package com.plesko.lesson2.main;

import com.plesko.lesson2.service.ReverseOrderArgumentService;

public class ReverseOrderArgumentMain {

    public static void main(String[] args) {
        ReverseOrderArgumentService reverseOrderArgumentService = new ReverseOrderArgumentService();
        String answer = reverseOrderArgumentService.reverse(args);
        System.out.println(answer);
    }
}
