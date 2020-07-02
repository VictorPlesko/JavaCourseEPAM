package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Replacement;

import java.util.ArrayList;

public class CharArrayReplacementImpl implements Replacement {

    private final static char SPACE = ' ';

    @Override
    public String replaceLetterByIndex(String text, int index, char newSymbol) throws CustomException {
        if (text == null || index < 0) {
            throw new CustomException("Invalid parameters");
        }
        char[] letters = text.toCharArray();
        int letterNumberInWord = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letterNumberInWord == index && letters[i] != SPACE) {
                letters[i] = newSymbol;
            }
            letterNumberInWord++;
            if (letters[i] == SPACE) {
                letterNumberInWord = 0;
            }
        }
        return String.valueOf(letters);
    }

    @Override
    public String replaceMistake(String text, char letterBeforeMistake,
                                 char mistake, char correction) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == letterBeforeMistake && letters[i + 1] == mistake) {
                letters[i + 1] = correction;
            }
        }
        return String.valueOf(letters);
    }

    @Override
    public String replaceWordWithSubstring(String text, int wordSize, String newString) throws CustomException {
        if (text == null || newString == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        char[] letters = text.toCharArray();
        char[] newWordChar = newString.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        int currentWordSize = 0;
        for (int i = 0; i <= letters.length; i++) {
            if (i == letters.length || letters[i] == SPACE) {
                if (wordSize != currentWordSize) {
                    for (int j = i - currentWordSize; j < i; j++) {
                        result.add(letters[j]);
                    }
                } else {
                    for (int j = 0; j < newString.length(); j++) {
                        result.add(newWordChar[j]);
                    }
                }
                result.add(SPACE);
                currentWordSize = 0;
            } else {
                currentWordSize++;
            }
        }
        return arrayCharacterToString(result);
    }

    private String arrayCharacterToString(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
