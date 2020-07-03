package com.traulko.task5.creator;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.reader.ConsoleReader;
import com.traulko.task5.reader.CustomFileReader;

public class CustomCreator {
    public String readTextFromConsole() {
        ConsoleReader consoleReader = new ConsoleReader();
        return consoleReader.readLine();
    }

    public String readTextFromFile(String fileName) throws IncorrectValueException {
        CustomFileReader fileReader = new CustomFileReader();
        return fileReader.readLine(fileName);
    }

    public int readNumberFromConsole() {
        ConsoleReader consoleReader = new ConsoleReader();
        return consoleReader.readDigit();
    }
}
