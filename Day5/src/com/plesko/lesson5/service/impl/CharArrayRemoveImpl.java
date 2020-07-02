package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Remove;

import java.util.ArrayList;

public class CharArrayRemoveImpl implements Remove {

    private final static char SPACE = ' ';
    private final static char[] VOWELS = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    @Override
    public String deleteAllCharactersNotLetter(String text) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (!Character.isLetter(letters[i]) && !Character.isSpaceChar(letters[i])) {
                letters[i] = SPACE;
            }
        }
        return String.valueOf(letters);
    }

    @Override
    public String deleteWordBeginningWithConsonant(String text, int wordSize) throws CustomException {
        if (text == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        char[] letters = text.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        int currentWordSize = 0;
        for (int i = 0; i <= letters.length; i++) {
            if (i == letters.length || letters[i] == SPACE) {
                int startWord = i - currentWordSize;
                if (wordSize != currentWordSize) {
                    for (int j = startWord; j < i; j++) {
                        result.add(letters[j]);
                    }
                    result.add(SPACE);
                } else if (!Character.isLetter(letters[startWord]) || isVowels(letters[startWord])) {
                    for (int j = startWord; j < i; j++) {
                        result.add(letters[j]);
                    }
                }
                currentWordSize = 0;
            } else {
                currentWordSize++;
            }
        }
        return arrayCharacterToString(result);
    }

    private boolean isVowels(char letter) {
        for (char vowel : VOWELS) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }

    private String arrayCharacterToString(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
