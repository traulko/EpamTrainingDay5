package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.DeleteTextComponent;
import com.traulko.task5.service.reform.ReformTextService;

import java.util.List;

public class CharArrayDeleteTextComponentImpl implements DeleteTextComponent {
    public static final String VOWELS = "aeiouаоеёюиуыэя";

    @Override
    public String deleteSymbolsExceptLetters(String text) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty())) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        char[] textCharFormat = text.toCharArray();
        for (int i = 0; i < textCharFormat.length; i++) {
            if ((!Character.isLetter(textCharFormat[i])) && (textCharFormat[i] != '\n')) {
                textCharFormat[i] = ' ';
            }
        }
        return String.valueOf(textCharFormat);
    }

    @Override
    public String deleteWordOfGivenLength(String text, int length) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (length <= 0)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        ReformTextService reformTextService = new ReformTextService();
        List<String> words = reformTextService.splitTextOnWord(text);
        for (int i = 0; i < words.size(); i++) {
            boolean isEqualLength = words.get(i).length() == length;
            boolean isFirstSymbolConsonant = isFirstWordSymbolConsonant(words.get(i));
            if (isEqualLength && isFirstSymbolConsonant) {
                words.remove(i);
            }
        }
        return reformTextService.getWordsStringFormat(words);
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));
        return (VOWELS.indexOf(firstSymbol) != -1);
    }
}
