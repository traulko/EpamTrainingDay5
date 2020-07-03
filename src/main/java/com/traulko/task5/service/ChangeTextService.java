package com.traulko.task5.service;

import com.traulko.task5.exception.IncorrectValueException;

public interface ChangeTextService {
    String replaceCharacter(String text, int characterIndexToReplace,
                            String replacingCharacter) throws IncorrectValueException;
    String fixMistake(String text, String mistake, String mistakeReplacing) throws IncorrectValueException;

    // TODO: 03.07.2020  
    String replaceSubstringCertainLength(String text, String substring, int wordSize) throws IncorrectValueException;
}
