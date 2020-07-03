package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Remove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRemoveImpl implements Remove {

    private final static String PUNCTUATION = "[\\p{Punct}]";
    private final static String SPACE = " ";
    private final static String REGEX_FOR_DELETE_WORD_BEGINNING_WITH_CONSONANT = "\\b[A-Za-z&&[^AEIOUaeiou]]"
            + "[\\p{Lower}\\p{Upper}]{%d}\\b";

    @Override
    public String deleteAllCharactersNotLetter(String text) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder regex = new StringBuilder();
        regex.append(PUNCTUATION);
        Pattern punctuationPattern = Pattern.compile(regex.toString());
        Matcher punctuationMatcher = punctuationPattern.matcher(text);
        return punctuationMatcher.replaceAll(SPACE);
    }

    @Override
    public String deleteWordBeginningWithConsonant(String text, int wordSize) throws CustomException {
        if (text == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        String regex = String.format(REGEX_FOR_DELETE_WORD_BEGINNING_WITH_CONSONANT, wordSize - 1);
        Pattern wordPattern = Pattern.compile(regex);
        Matcher wordMatcher = wordPattern.matcher(text);
        return wordMatcher.replaceAll("");
    }
}
