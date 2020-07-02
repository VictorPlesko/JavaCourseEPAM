package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Replacement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacementImpl implements Replacement {

    private final static String ALPHABET = "\\p{Lower}\\p{Upper}";
    private final static String PUNCTUATION = "\\p{Punct}";
    private final static String[] BRACE = {"{", "}"};
    private final static String[] BRACKET = {"(", ")"};
    private final static String[] SQUARE_BRACKETS = {"[", "]"};
    private final static String STAR = "*";
    private final static String WORD_BOUNDARY = "\\b";

    @Override
    public String replaceLetterByIndex(String text, int index, char newSymbol) throws CustomException {
        if (text == null || index < 0) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        StringBuilder regex = new StringBuilder();
        regex.append(BRACKET[0]).append(SQUARE_BRACKETS[0]).append(ALPHABET).append(SQUARE_BRACKETS[1])
                .append(BRACE[0]).append(index).append(BRACE[1]).append(BRACKET[1])
                .append(BRACKET[0]).append(SQUARE_BRACKETS[0]).append(ALPHABET).append(SQUARE_BRACKETS[1]).append(BRACKET[1])
                .append(BRACKET[0]).append(SQUARE_BRACKETS[0]).append(ALPHABET).append(PUNCTUATION).append(SQUARE_BRACKETS[1])
                .append(STAR).append(BRACKET[1]);
        Pattern letterSearchPattern = Pattern.compile(regex.toString());
        Matcher letterSearchMatcher = letterSearchPattern.matcher(text);
        while (letterSearchMatcher.find()) {
            letterSearchMatcher.appendReplacement(result, letterSearchMatcher.group(1) + newSymbol
                    + letterSearchMatcher.group(3));
        }
        return result.toString();
    }

    @Override
    public String replaceMistake(String text, char letterBeforeMistake,
                                 char mistake, char correction) throws CustomException {
        if (text == null) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder regex = new StringBuilder();
        regex.append(letterBeforeMistake).append(mistake);
        Pattern mistakePattern = Pattern.compile(regex.toString());
        Matcher mistakeMatcher = mistakePattern.matcher(text);
        String result = mistakeMatcher.replaceAll(Character.toString(letterBeforeMistake)
                + Character.toString(correction));
        return result;
    }

    @Override
    public String replaceWordWithSubstring(String text, int wordSize, String newString) throws CustomException {
        if (text == null || newString == null || wordSize < 1) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder regex = new StringBuilder();
        regex.append(WORD_BOUNDARY).append(SQUARE_BRACKETS[0]).append(ALPHABET).append(SQUARE_BRACKETS[1])
                .append(BRACE[0]).append(wordSize).append(BRACE[1]).append(WORD_BOUNDARY);
        Pattern wordPattern = Pattern.compile(regex.toString());
        Matcher wordMatcher = wordPattern.matcher(text);
        return wordMatcher.replaceAll(newString);
    }
}
