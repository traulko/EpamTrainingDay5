package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.ChangeTextService;
import com.traulko.task5.validator.CustomValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextImpl implements ChangeTextService {
    public static final String FOUR_FIRST_WORD_CHARACTER = "(\\b\\p{L}{%d})\\p{L}";
    public static final String WORD_LAST_CHARACTER_CHANGED = "$1%s";
    public static final String CERTAIN_LENGTH_WORD = "\\b\\p{L}{%d}\\b";

    @Override
    public String replaceCharacter(String text, int replaceCharIndex, String replacing) throws IncorrectValueException {
        CustomValidator customValidator = new CustomValidator();

        if ((text == null) || (text.isEmpty()) || (!customValidator.isCorrectSymbol(replaceCharIndex)) || (replacing == null) || (replacing.length() != 1)) {
            throw new IncorrectValueException("incorrect data");
        }
        String changedText;
        Pattern pattern = Pattern.compile(String.format(FOUR_FIRST_WORD_CHARACTER, replaceCharIndex));
        Matcher matcher = pattern.matcher(text);
        changedText = matcher.replaceAll(String.format(WORD_LAST_CHARACTER_CHANGED, replacing));
        return changedText;
    }

    @Override
    public String fixMistake(String text, String mistake, String replacing) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (replacing == null)
                || (mistake.length() != replacing.length())) {
            throw new IncorrectValueException("incorrect data");
        }
        Pattern pattern = Pattern.compile(mistake);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacing);
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordLength) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (substring == null) || (wordLength <= 0)) {
            throw new IncorrectValueException("incorrect data");
        }
        Pattern pattern = Pattern.compile(String.format(CERTAIN_LENGTH_WORD, wordLength));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(substring);
    }
}
