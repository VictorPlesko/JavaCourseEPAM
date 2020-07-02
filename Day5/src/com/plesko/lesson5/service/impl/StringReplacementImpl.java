package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Replacement;

public class StringReplacementImpl implements Replacement {

    private final static String REGEX = "[\\p{Blank}]";

    @Override
    public String replaceLetterByIndex(String text, int index, char newSymbol) throws CustomException {
        if (text == null || index < 0) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split(REGEX);
        for (String word : words) {
            StringBuilder wordSB = new StringBuilder(word);
            if (index < word.length()) {
                wordSB = wordSB.replace(index, index + 1, String.valueOf(newSymbol));
            }
            result.append(wordSB.toString()).append(" ");
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }

    @Override
    public String replaceMistake(String text, char letterBeforeMistake,
                                 char mistake, char correction) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split(REGEX);
        for (String word : words) {
            StringBuilder wordSB = new StringBuilder(word);
            for (int i = 0; i < word.length() - 1; i++) {
                if (wordSB.charAt(i) == letterBeforeMistake && wordSB.charAt(i + 1) == mistake) {
                    wordSB = wordSB.replace(i + 1, i + 2, String.valueOf(correction));
                }
            }
            result.append(wordSB).append(" ");
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }

    @Override
    public String replaceWordWithSubstring(String text, int wordSize, String newString) throws CustomException {
        if (text == null || newString == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split(REGEX);
        for (String word : words) {
            if (word.length() == wordSize) {
                word = newString;
            }
            result.append(word).append(" ");
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }
}
