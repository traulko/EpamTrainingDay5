package com.traulko.task5.parser;

import com.traulko.task5.exception.IncorrectValueException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleParser {
    public String parseLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int parseNumber() throws IncorrectValueException {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IncorrectValueException("Incorrect int value", e);
        }
    }
}
