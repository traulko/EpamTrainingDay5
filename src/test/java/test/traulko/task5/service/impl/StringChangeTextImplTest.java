package test.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.impl.StringChangeTextImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringChangeTextImplTest {
    StringChangeTextImpl stringChangeText;

    @BeforeMethod
    public void setUp() {
        stringChangeText = new StringChangeTextImpl();
    }

    @AfterMethod
    public void tearDown() {
        stringChangeText = null;
    }

    @Test
    public void replaceCharacterPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.replaceCharacter(text, 2, "g");
            String expected = "A crgdit cagd is an ingispensable pagt of lige in Amgrica.";
            assertEquals(actual, expected, "replaceSubstringCertainLengthPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceCharacterNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.replaceCharacter(text, 2, "g");
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "replaceSubstringCertainLengthNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceCharacterExceptionTest() throws IncorrectValueException {
        stringChangeText.replaceCharacter(null, 0, "q");
    }

    @Test
    public void fixMistakePositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.fixMistake(text, "i", "q");
            String expected = "A credqt card qs an qndqspensable part of lqfe qn Amerqca.";
            assertEquals(actual, expected, "fixMistakePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void fixMistakeNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.fixMistake(text, "i", "q");
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "fixMistakeNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void fixMistakeExceptionTest() throws IncorrectValueException {
        stringChangeText.fixMistake(null, null, null);
    }

    @Test
    public void replaceSubstringCertainLengthPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.replaceSubstringCertainLength(text, "card", 4);
            String expected = "A credit card is an indispensable card of card in America.";
            assertEquals(actual, expected, "replaceSubstringCertainLengthPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void replaceSubstringCertainLengthNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringChangeText.replaceSubstringCertainLength(text, "card", 4);
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "replaceSubstringCertainLengthNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void replaceSubstringCertainLengthExceptionTest() throws IncorrectValueException {
        stringChangeText.replaceSubstringCertainLength(null, null, 0);
    }
}