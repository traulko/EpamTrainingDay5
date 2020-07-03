package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.ChangeTextService;
import com.traulko.task5.service.reform.ReformTextService;

import java.util.List;

public class CharArrayChangeTextImpl implements ChangeTextService {

    @Override
    public String replaceCharacter(String text, int replaceCharIndex, String replacingChar) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (replaceCharIndex < 0)
                || (replacingChar == null) || (replacingChar.length() != 1)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        char[] charArray = text.toCharArray();
        char replacingCharFirstSymbol = replacingChar.charAt(0);
        int wordSymbolNumber = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (wordSymbolNumber == replaceCharIndex) {
                    charArray[i] = replacingCharFirstSymbol;
                }
                wordSymbolNumber++;
            } else {
                wordSymbolNumber = 0;
            }
        }
        return String.valueOf(charArray);
    }

    @Override
    public String fixMistake(String text, String mistake, String replacing) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (replacing == null) || (mistake.length() != replacing.length())) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        char[] textCharFormat = text.toCharArray();
        char[] mistakeCharFormat = mistake.toCharArray();
        char[] replacingCharFormat = replacing.toCharArray();
        for (int i = 0; i < textCharFormat.length; i++) {
            boolean isMistake = true;
            if (textCharFormat[i] == mistakeCharFormat[0]) {
                for (int j = 1; j < mistakeCharFormat.length; j++) {
                    if (textCharFormat[i + j] != mistakeCharFormat[j]) {
                        isMistake = false;
                        break;
                    }
                }
                if (isMistake) {
                    for (int j = 0; j < mistakeCharFormat.length; j++) {
                        textCharFormat[i + j] = replacingCharFormat[j];
                    }
                }
            }
        }
        return String.valueOf(textCharFormat);
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordSize) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (substring == null)
                || (wordSize <= 0)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        ReformTextService reformTextService = new ReformTextService();
        List<String> words = reformTextService.splitTextOnWord(text);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == wordSize) {
                words.set(i, substring);
            }
        }
        return reformTextService.getWordsStringFormat(words);
    }
}
