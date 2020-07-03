package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.DeleteTextComponent;

public class StringDeleteTextComponentImpl implements DeleteTextComponent {
    public static final String VOWELS = "aeiouаоеёюиуыэя";
    public static final String CHARACTER_EXCEPT_LETTER = "[\\p{Punct}\\d]";

    @Override
    public String deleteSymbolsExceptLetters(String text) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty())) {
            throw  new IncorrectValueException("incorrect data");
        }
        return text.replaceAll(CHARACTER_EXCEPT_LETTER," ");
    }

    @Override
    public String deleteWordOfGivenLength(String text, int length) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (length <= 0)) {
            throw new IncorrectValueException("incorrect data");
        }
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            String wordWithoutPunctuation = deleteSymbolsExceptLetters(word);
            wordWithoutPunctuation = wordWithoutPunctuation.replace(" ", "");
            if ((wordWithoutPunctuation.length() == length)
                    && (isFirstWordSymbolConsonant(wordWithoutPunctuation))) {
                if ((word.length() != wordWithoutPunctuation.length())) {
                    char lastCharacter = word.charAt(word.length() - 1);
                    stringBuilder.append(lastCharacter);
                    stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));

        return (VOWELS.indexOf(firstSymbol) == -1);
    }
}
