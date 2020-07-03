package com.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.Replacement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacementImpl implements Replacement {

    private final static String REGEX_FOR_REPLACE_LETTER_BY_INDEX = "([\\p{Lower}\\p{Upper}]{%d})"
            + "([\\p{Lower}\\p{Upper}])([\\p{Lower}\\p{Upper}\\p{Punct}]*)";
    private final static String REGEX_FOR_REPLACE_WORD_WITH_SUBSTRING = "\\b[\\p{Lower}\\p{Upper}]{%d}\\b";

    @Override
    public String replaceLetterByIndex(String text, int index, char newSymbol) throws CustomException {
        if (text == null || index < 0) {
            throw new CustomException("Invalid parameters");
        }
        StringBuilder result = new StringBuilder();
        String regex = String.format(REGEX_FOR_REPLACE_LETTER_BY_INDEX, index);
        Pattern letterSearchPattern = Pattern.compile(regex);
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
        String regex = String.format(REGEX_FOR_REPLACE_WORD_WITH_SUBSTRING, wordSize);
        Pattern wordPattern = Pattern.compile(regex);
        Matcher wordMatcher = wordPattern.matcher(text);
        return wordMatcher.replaceAll(newString);
    }
}
