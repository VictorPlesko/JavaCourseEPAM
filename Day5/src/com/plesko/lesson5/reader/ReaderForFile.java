package com.plesko.lesson5.reader;

import com.plesko.lesson5.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderForFile {

    private final static String DEFAULT_PATH_TO_FILE = "datares\\data.txt";

    public String readText(String filePath) throws CustomException {
        if (filePath == null) {
            throw new CustomException("Null object");
        }
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_PATH_TO_FILE);
        }
        List<String> text;
        try {
            text = Files.readAllLines(path);
        } catch (IOException ex) {
            throw new CustomException("Problems reading from file", ex);
        }
        return joinStrings(text);
    }

    private String joinStrings(List<String> text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : text) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
