package com.plesko.lesson5.reader;

import com.plesko.lesson5.console.MenuConsole;

import java.util.Scanner;

public class ConsoleReader {

    public String readText() {
        Scanner scanner = new Scanner(System.in);
        MenuConsole menuConsole = new MenuConsole();
        menuConsole.showMenu();
        return scanner.nextLine();
    }
}
