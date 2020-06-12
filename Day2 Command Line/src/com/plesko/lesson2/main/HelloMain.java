package com.plesko.lesson2.main;

import com.plesko.lesson2.service.HelloService;

public class HelloMain {

    public static void main(String[] args) {
        if (args.length != 1 || args[0].equals("")){
            throw new IllegalArgumentException("Invalid incoming arguments.");
        }
        HelloService helloService = new HelloService();
        String answer = helloService.sayHelloWithName(args[0]);
        System.out.println(answer);
    }
}
