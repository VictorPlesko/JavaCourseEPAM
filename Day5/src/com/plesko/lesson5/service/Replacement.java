package com.plesko.lesson5.service;

import com.plesko.lesson5.exception.CustomException;

public interface Replacement {

    String replaceLetterByIndex(String text, int index, char newSymbol) throws CustomException;

    String replaceMistake(String text, char letterBeforeMistake, char mistake, char correction) throws CustomException;

    String replaceWordWithSubstring(String text, int wordSize, String newString) throws CustomException;
}
