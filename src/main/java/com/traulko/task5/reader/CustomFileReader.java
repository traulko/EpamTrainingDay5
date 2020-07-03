package com.traulko.task5.reader;

import com.traulko.task5.exception.IncorrectValueException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReader {
    public String readLine(String fileName) throws IncorrectValueException {
        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
            throw new IncorrectValueException("This file not exists");
        }
        try {
            List<String> hyphenFreeString = Files.readAllLines(path);
            return String.join("\n", hyphenFreeString);
        } catch (IOException e) {
            throw new IncorrectValueException("This file is incorrect", e);
        }
    }
}
