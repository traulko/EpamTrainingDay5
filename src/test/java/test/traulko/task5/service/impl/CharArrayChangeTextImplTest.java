package test.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.impl.CharArrayChangeTextImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharArrayChangeTextImplTest {
    CharArrayChangeTextImpl charArrayChangeText;

    @BeforeMethod
    public void setUp() {
        charArrayChangeText = new CharArrayChangeTextImpl();
    }

    @AfterMethod
    public void tearDown() {
        charArrayChangeText = null;
    }

    @Test
    public void replaceCharacterPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = charArrayChangeText.replaceCharacter(text, 1, "0");
            String expected = "A c0edit c0rd i0 a0 i0dispensable p0rt o0 l0fe i0 A0erica.";
            assertEquals(actual, expected, "replaceCharacterPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceCharacterNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = charArrayChangeText.replaceCharacter(text, 1, "0");
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "replaceCharacterNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceCharacterExceptionTest() throws IncorrectValueException {
        charArrayChangeText.replaceCharacter(null, 0, "g");
    }

    @Test
    public void fixMistakePositiveTest() {
        String text = "Hello wordl!";
        try {
            String actual = charArrayChangeText.fixMistake(text, "wordl", "world");
            String expected = "Hello world!";
            assertEquals(actual, expected, "fixMistakePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void fixMistakeNegativeTest() {
        String text = "Hello wordl!";
        try {
            String actual = charArrayChangeText.fixMistake(text, "wordl", "world");
            String expected = "Hello world!";
            assertEquals(actual, expected, "fixMistakeNegativeTest failed as..");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void fixMistakeExceptionTest() throws IncorrectValueException {
        charArrayChangeText.fixMistake(null, null, null);
    }

    @Test
    public void replaceSubstringCertainLengthPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = charArrayChangeText.replaceSubstringCertainLength(text, "part", 2);
            String expected = "A credit card part part indispensable part part life part America.";
            assertEquals(actual, expected, "replaceSubstringCertainLengthPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceSubstringCertainLengthNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = charArrayChangeText.replaceSubstringCertainLength(text, "part", 3);
            String expected = "A credit card part part indispensable part part life part America.";
            assertNotEquals(actual, expected, "replaceSubstringCertainLengthNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceSubstringCertainLengthExceptionTest() throws IncorrectValueException {
        charArrayChangeText.replaceSubstringCertainLength(null, null, 0);
    }
}