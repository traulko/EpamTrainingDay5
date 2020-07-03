package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.DeleteTextComponent;

public class StringDeleteTextComponentImpl implements DeleteTextComponent {
    public static final String VOWELS = "aeiouаоеёюиуыэя";
    public static final String EXCEPT_LETTER = "[\\p{Punct}\\d]";

    @Override
    public String deleteSymbolsExceptLetters(String text) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty())) {
            throw new IncorrectValueException("Incorrect parameter");
        }
        return text.replaceAll(EXCEPT_LETTER, " ");
    }

    @Override
    public String deleteWordOfGivenLength(String text, int length) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (length <= 0)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String wordOnlyLetters = deleteSymbolsExceptLetters(word);
            wordOnlyLetters = wordOnlyLetters.replace(" ", "");
            if ((wordOnlyLetters.length() == length)
                    && (isFirstWordSymbolConsonant(wordOnlyLetters))) {
                if ((word.length() != wordOnlyLetters.length())) {
                    char lastCharacter = word.charAt(word.length() - 1);
                    stringBuilder.append(lastCharacter);
                    stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));
        return (VOWELS.indexOf(firstSymbol) != -1);
    }
}
