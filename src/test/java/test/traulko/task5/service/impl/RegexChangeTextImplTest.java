package test.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.impl.RegexChangeTextImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegexChangeTextImplTest {
    RegexChangeTextImpl regexChangeText;

    @BeforeMethod
    public void setUp() {
        regexChangeText = new RegexChangeTextImpl();
    }

    @AfterMethod
    public void tearDown() {
        regexChangeText = null;
    }

    @Test
    public void replaceCharacterPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.replaceCharacter(text, 2, "g");
            String expected = "A crgdit cagd is an ingispensable pagt of lige in Amgrica.";
            assertEquals(actual, expected, "replaceCharacterPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceCharacterNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.replaceCharacter(text, 1, "g");
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "replaceCharacterNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceCharacterExceptionTest() throws IncorrectValueException {
        regexChangeText.replaceCharacter(null, 0, "g");
    }

    @Test
    public void fixMistakePositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.fixMistake(text, "i", "1");
            String expected = "A cred1t card 1s an 1nd1spensable part of l1fe 1n Amer1ca.";
            assertEquals(actual, expected, "fixMistakePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void fixMistakeNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.fixMistake(text, "i", "1");
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "fixMistakeNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void fixMistakeExceptionTest() throws IncorrectValueException {
        regexChangeText.fixMistake(null, "", "");
    }

    @Test
    public void replaceSubstringCertainLengthPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.replaceSubstringCertainLength(text, "haha", 4);
            String expected = "A credit haha is an indispensable haha of haha in America.";
            assertEquals(actual, expected, "replaceSubstringCertainLengthPositiveTest");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceSubstringCertainLengthNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = regexChangeText.replaceSubstringCertainLength(text, "haha", 4);
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "replaceSubstringCertainLengthNegativeTest");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceSubstringCertainLengthExceptionTest() throws IncorrectValueException {
        regexChangeText.replaceCharacter(null, 0, "character");
    }
}