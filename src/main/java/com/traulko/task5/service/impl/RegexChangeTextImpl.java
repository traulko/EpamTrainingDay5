package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.ChangeTextService;
import com.traulko.task5.validator.CustomValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChangeTextImpl implements ChangeTextService {
    public static final String FOUR_FIRST_WORD_CHARACTER = "(\\b\\p{L}{%d})\\p{L}";
    public static final String WORD_WHERE_LAST_CHARACTER_IS_CHANGED = "$1%s";
    public static final String WORD_CERTAIN_LENGTH = "\\b\\p{L}{%d}\\b";

    @Override
    public String replaceCharacter(String text, int characterIndexToReplace, String replacingCharacter) throws IncorrectValueException {
        CustomValidator customValidator = new CustomValidator();

        if ((text == null) || (text.isEmpty()) || (!customValidator.isCorrectSymbol(characterIndexToReplace))
                || (replacingCharacter == null) || (replacingCharacter.length() != 1)) {
            throw new IncorrectValueException("incorrect data");
        }
        String editedText;
        Pattern pattern = Pattern.compile(String.format(FOUR_FIRST_WORD_CHARACTER, characterIndexToReplace));
        Matcher matcher = pattern.matcher(text);
        editedText = matcher.replaceAll(String.format(WORD_WHERE_LAST_CHARACTER_IS_CHANGED, replacingCharacter));
        return editedText;
    }

    @Override
    public String fixMistake(String text, String mistake, String mistakeReplacing) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (mistake == null) || (mistakeReplacing == null)
                || (mistake.length() != mistakeReplacing.length())) {
            throw new IncorrectValueException("incorrect data");
        }
        Pattern pattern = Pattern.compile(mistake);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(mistakeReplacing);
    }

    @Override
    public String replaceSubstringCertainLength(String text, String substring, int wordLength) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (substring == null) || (wordLength <= 0)) {
            throw new IncorrectValueException("incorrect data");
        }
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(substring);
    }
}
