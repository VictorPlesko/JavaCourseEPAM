package com.plesko.lesson4_1.creator;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.parser.ArrayParser;
import com.plesko.lesson4_1.reader.ConsoleReader;
import com.plesko.lesson4_1.reader.ReaderForFile;

import java.util.Random;

public class ArrayCreator {

    public OneDimensionalArray randomArray(int size) throws CustomException {
        OneDimensionalArray result = new OneDimensionalArray(size);
        Random random = new Random();
        for (int i = 0; i < result.size(); i++) {
            result.set(i, random.nextInt());
        }
        return result;
    }

    public OneDimensionalArray arrayFromConsole() throws CustomException {
        ConsoleReader consoleReader = new ConsoleReader();
        ArrayParser arrayParser = new ArrayParser();
        String[] strArray = consoleReader.readArray();
        int[] intArray = arrayParser.parseToIntegerArray(strArray);
        return new OneDimensionalArray(intArray);
    }

    public OneDimensionalArray arrayFromFile(String file) throws CustomException {
        ReaderForFile readerForFile = new ReaderForFile();
        ArrayParser arrayParser = new ArrayParser();
        String[] strArray = readerForFile.readArray(file);
        int[] intArray = arrayParser.parseToIntegerArray(strArray);
        return new OneDimensionalArray(intArray);
    }
}
