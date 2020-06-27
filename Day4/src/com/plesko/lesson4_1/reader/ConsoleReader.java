package com.plesko.lesson4_1.reader;

import com.plesko.lesson4_1.console.MenuConsole;

import java.util.Scanner;

public class ConsoleReader {

    private final static String REGEX = " ";

    public String[] readArray() {
        String[] result;
        Scanner scanner = new Scanner(System.in);
        MenuConsole menuConsole = new MenuConsole();
        menuConsole.showMenu();
        result = scanner.nextLine().split(REGEX);
        return result;
    }
}
