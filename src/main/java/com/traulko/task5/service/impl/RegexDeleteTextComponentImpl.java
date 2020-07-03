package com.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.DeleteTextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteTextComponentImpl implements DeleteTextComponent {
    public static final String VOWELS = "aeiouyуеыаоэяию";
    public static final String EXCEPT_LETTER = "[\\p{Punct}\\d]";
    public static final String CERTAIN_LENGTH_WORD = "\\b(\\p{L})\\p{L}{%d}\\b";

    @Override
    public String deleteSymbolsExceptLetters(String text) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty())) {
            throw new IncorrectValueException("incorrect data");
        }
        Pattern pattern = Pattern.compile(EXCEPT_LETTER);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(" ");
    }

    @Override
    public String deleteWordOfGivenLength(String text, int length) throws IncorrectValueException {
        if ((text == null) || (text.isEmpty()) || (length <= 0)) {
            throw new IncorrectValueException("incorrect data");
        }
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile(String.format(CERTAIN_LENGTH_WORD, length - 1));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (isFirstWordSymbolConsonant(matcher.group(1))) {
                matcher.appendReplacement(stringBuffer, "");
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private boolean isFirstWordSymbolConsonant(String word) {
        char firstSymbol = Character.toLowerCase(word.charAt(0));
        return VOWELS.indexOf(firstSymbol) != -1;
    }
}
