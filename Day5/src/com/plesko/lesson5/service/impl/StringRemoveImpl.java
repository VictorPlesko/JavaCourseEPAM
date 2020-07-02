package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Remove;

public class StringRemoveImpl implements Remove {

    private final static String REGEX = "[\\p{Blank}]";
    private final static String SPACE = " ";
    private final static String VOWELS = "AEIOUaeiou";

    @Override
    public String deleteAllCharactersNotLetter(String text) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder textSB = new StringBuilder(text);
        for (int i = 0; i < textSB.length(); i++) {
            if (!Character.isLetter(textSB.charAt(i)) && !Character.isSpaceChar(textSB.charAt(i))) {
                textSB = textSB.replace(i, i + 1, SPACE);
            }
        }
        return textSB.toString();
    }

    @Override
    public String deleteWordBeginningWithConsonant(String text, int wordSize) throws CustomException {
        if (text == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split(REGEX);
        for (String word : words) {
            if (word.length() != wordSize || VOWELS.indexOf(word.charAt(0)) != -1) {
                result.append(word).append(" ");
            }
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }
}
