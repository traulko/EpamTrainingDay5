package com.traulko.task5.service.reform;


import com.traulko.task5.exception.IncorrectValueException;

import java.util.ArrayList;
import java.util.List;

public class ReformTextService {
    public String getWordsStringFormat(List<String> words) throws IncorrectValueException {
        if (words == null || words.isEmpty()) {
            throw new IncorrectValueException("Incorrect words list");
        }
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            text.append(word);
        }
        return text.toString().trim();
    }

    // TODO: 03.07.2020  
    public List<String> splitTextOnWord(String text) throws IncorrectValueException {
        if (text == null || text.length() == 0) {
            throw new IncorrectValueException("Incorrect text");
        }
        List<String> words = new ArrayList<>();
        char[] charArray = text.toCharArray();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(charArray[i])) {
                word.append(charArray[i]);
                if (text.length() - 1 == i) {
                    words.add(word.toString());
                    break;
                }
            } else {
                words.add(word.toString());
                if (charArray[i] != ' ') {
                    words.add(String.valueOf(charArray[i]));
                }
                words.add(" ");
                word = new StringBuilder();
            }
        }
        return words;
    }
}