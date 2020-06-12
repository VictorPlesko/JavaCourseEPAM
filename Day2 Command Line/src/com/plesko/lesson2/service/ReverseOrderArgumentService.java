package com.plesko.lesson2.service;

public class ReverseOrderArgumentService {

    public String reverse(String[] args){
        StringBuilder sb = new StringBuilder();
        for (int i = args.length - 1; i >= 0; i--) sb.append(args[i]).append(" ");
        return sb.toString();
    }
}
