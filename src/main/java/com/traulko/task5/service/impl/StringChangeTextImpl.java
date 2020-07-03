package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.ChangeTextService;
import com.traulko.task5.validator.CustomValidator;

public class StringChangeTextImpl implements ChangeTextService {
    public static final String FOUR_FIRST_WORD_CHARACTER = "(\\b\\p{L}{%d})\\p{L}";
    public static final String WORD_WITHOUT_LAST_SYMBOL = "$1";
    public static final String EXCEPT_LETTER = "[\\p{Punct}\\d]";

    @Override
    public String replaceCharacter(String text, int characterIndexToReplace, String replacingCharacter) throws IncorrectValueException {
        CustomValidator customValidator = new CustomValidator();
        if ((text == null) || (text.isEmpty()) || (!customValidator.isCorrectSymbol(characterIndexToReplace))
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        return text.replaceAll(String.format(FOUR_FIRST_WORD_CHARACTER,
                characterIndexToReplace), WORD_WITHOUT_LAST_SYMBOL.concat(replacingCharacter));
    }

    @Override
    public String fixMistake(String text, String mistake, String replacing) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (replacing == null)
                || (mistake.length() != replacing.length())) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        return text.replaceAll(mistake, replacing);
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordLength) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (substring == null)
                || (wordLength <= 0)) {
            throw new IncorrectValueException("Incorrect parameters");
        }
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll(EXCEPT_LETTER, "");
            if (word.length() == wordLength) {
                words[i] = substring;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
