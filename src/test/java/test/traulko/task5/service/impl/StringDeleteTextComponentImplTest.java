package test.traulko.task5.service.impl;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.impl.StringDeleteTextComponentImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDeleteTextComponentImplTest {
    StringDeleteTextComponentImpl stringDeleteTextComponent;

    @BeforeMethod
    public void setUp() {
        stringDeleteTextComponent = new StringDeleteTextComponentImpl();
    }

    @AfterMethod
    public void tearDown() {
        stringDeleteTextComponent = null;
    }

    @Test
    public void deleteSymbolsExceptLettersPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringDeleteTextComponent.deleteSymbolsExceptLetters(text);
            String expected = "A credit card is an indispensable part of life in America ";
            assertEquals(actual, expected, "deleteSymbolsExceptLettersPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteSymbolsExceptLettersNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringDeleteTextComponent.deleteSymbolsExceptLetters(text);
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "deleteSymbolsExceptLettersNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void deleteSymbolsExceptLettersExceptionTest() throws IncorrectValueException {
        stringDeleteTextComponent.deleteSymbolsExceptLetters(null);
    }

    @Test
    public void deleteWordOfGivenLengthPositiveTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringDeleteTextComponent.deleteWordOfGivenLength(text, 7);
            String expected = "A credit card is an indispensable part of life in .";
            assertEquals(actual, expected, "deleteWordOfGivenLengthPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteWordOfGivenLengthNegativeTest() {
        String text = "A credit card is an indispensable part of life in America.";
        try {
            String actual = stringDeleteTextComponent.deleteWordOfGivenLength(text, 7);
            String expected = "A credit card is an indispensable part of life in America.";
            assertNotEquals(actual, expected, "deleteWordOfGivenLengthNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void deleteWordOfGivenLengthExceptionTest() throws IncorrectValueException {
        stringDeleteTextComponent.deleteWordOfGivenLength(null, 0);
    }
}