package com.plesko.lesson7.main;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class WorkWithLocale {

    public static void main(String[] args) {
        System.out.println("Enter:\n1 - for english\n2 - for belarusian\n3 - for russian");
        char input = '0';
        try {
            input = (char) System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String language = "";
        String country = "";
        switch (input) {
            case '2':
                language = "be";
                country = "BY";
                break;
            case '3':
                language = "ru";
                country = "RU";
                break;
            default:
                System.out.println("This command was not found.");
        }
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("property.message", locale);
        String str1 = resourceBundle.getString("key1");
        System.out.println(str1);
        String str2 = resourceBundle.getString("key2");
        System.out.println(str2);
    }
}
