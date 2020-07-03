package com.traulko.task5.service;

import com.traulko.task5.exception.IncorrectValueException;

public interface DeleteTextComponent {
    String deleteSymbolsExceptLetters(String text) throws IncorrectValueException;

    String deleteWordOfGivenLength(String text, int length) throws IncorrectValueException;
}
