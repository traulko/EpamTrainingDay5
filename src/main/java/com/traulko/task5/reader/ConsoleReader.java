package com.traulko.task5.reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int readDigit() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
        // TODO: 03.07.2020  
    }
}
