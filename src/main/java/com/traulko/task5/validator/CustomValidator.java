package com.traulko.task5.validator;

public class CustomValidator {
    public static final int LONGEST_WORD_SIZE = 10000;

    public boolean isCorrectSymbol(int index) {
        return index >= 0 && index <= LONGEST_WORD_SIZE;
    }
}
