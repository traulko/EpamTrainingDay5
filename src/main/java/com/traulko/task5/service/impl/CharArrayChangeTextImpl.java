package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.ChangeTextService;
import com.traulko.task5.service.reform.ReformTextService;
import java.util.List;

public class CharArrayChangeTextImpl implements ChangeTextService {

    // TODO: 03.07.2020
    @Override
    public String replaceCharacter(String text, int characterIndexToReplace, String replacingCharacter) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (characterIndexToReplace < 0)
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        char[] charArray = text.toCharArray();
        char replacingCharacterCharFormat = replacingCharacter.charAt(0);
        int wordCharacterNumber = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (wordCharacterNumber == characterIndexToReplace) {
                    charArray[i] = replacingCharacterCharFormat;
                }
                wordCharacterNumber++;
            } else {
                wordCharacterNumber = 0;
            }
        }
        return String.valueOf(charArray);
    }

    @Override
    public String fixMistake(String text, String mistake, String mistakeReplacing) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (mistakeReplacing == null)
                || (mistake.length() != mistakeReplacing.length())) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        char[] textCharFormat = text.toCharArray();
        char[] mistakeCharFormat = mistake.toCharArray();
        char[] mistakeReplacingCharFormat = mistakeReplacing.toCharArray();
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
                        textCharFormat[i + j] = mistakeReplacingCharFormat[j];
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
            throw new IncorrectValueException("incorrect data");
        }
        ReformTextService reformTextService = new ReformTextService();
        List<String> words = reformTextService.splitTextOnWord(text);

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == wordSize) {
                words.set(i, substring);
            }
        }
        return reformTextService.updateText(words);
    }
}
