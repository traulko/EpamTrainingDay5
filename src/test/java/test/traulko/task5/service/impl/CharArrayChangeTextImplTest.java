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
    public void testFixMistake() {
    }

    @Test
    public void testReplaceSubstringCertainLength() {
    }
}