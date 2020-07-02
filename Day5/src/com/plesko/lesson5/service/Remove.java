package com.plesko.lesson5.service;

import com.plesko.lesson5.exception.CustomException;

public interface Remove {

    String deleteAllCharactersNotLetter(String text) throws CustomException;
    String deleteWordBeginningWithConsonant(String text, int wordSize) throws CustomException;
}
