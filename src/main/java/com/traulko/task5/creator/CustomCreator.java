package com.traulko.task5.creator;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.parser.ConsoleParser;
import com.traulko.task5.reader.CustomFileReader;

public class CustomCreator {
    public String readTextFromConsole() {
        ConsoleParser consoleParser = new ConsoleParser();
        return consoleParser.parseLine();
    }

    public String readTextFromFile(String fileName) throws IncorrectValueException {
        CustomFileReader fileReader = new CustomFileReader();
        return fileReader.readLine(fileName);
    }

    public int readNumberFromConsole() throws IncorrectValueException {
        ConsoleParser consoleParser = new ConsoleParser();
        return consoleParser.parseNumber();
    }
}
