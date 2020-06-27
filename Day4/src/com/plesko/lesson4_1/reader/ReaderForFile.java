package com.plesko.lesson4_1.reader;

import com.plesko.lesson4_1.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderForFile {

    private final static String DEFAULT_PATH_TO_FILE = "datares\\data.txt";
    private final static String REGEX = " ";

    public String[] readArray(String filePath) throws CustomException {
        if (filePath == null) {
            throw new CustomException("Null object");
        }
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_PATH_TO_FILE);
        }
        String[] result;
        try {
            result = Files.readAllLines(path).get(0).split(REGEX);
        } catch (IOException ex) {
            throw new CustomException("Problems reading from file", ex);
        }
        return result;
    }
}
