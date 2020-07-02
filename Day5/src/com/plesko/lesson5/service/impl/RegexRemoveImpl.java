package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Remove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRemoveImpl implements Remove {

    private final static String ALPHABET = "[\\p{Lower}\\p{Upper}]";
    private final static String PUNCTUATION = "[\\p{Punct}]";
    private final static String[] BRACE = {"{", "}"};
    private final static String SPACE = " ";
    private final static String WORD_BOUNDARY = "\\b";
    private final static String CONSONANT = "[A-Za-z&&[^AEIOUaeiou]]";

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
        StringBuilder regex = new StringBuilder();
        regex.append(WORD_BOUNDARY).append(CONSONANT).append(ALPHABET)
                .append(BRACE[0]).append(wordSize - 1).append(BRACE[1]).append(WORD_BOUNDARY);
        Pattern wordPattern = Pattern.compile(regex.toString());
        Matcher wordMatcher = wordPattern.matcher(text);
        return wordMatcher.replaceAll("");
    }
}
