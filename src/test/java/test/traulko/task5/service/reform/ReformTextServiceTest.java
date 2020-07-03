package test.traulko.task5.service.reform;

import com.traulko.task5.exception.IncorrectValueException;
import com.traulko.task5.service.reform.ReformTextService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ReformTextServiceTest {
    ReformTextService reformTextService;

    @BeforeMethod
    public void setUp() {
        reformTextService = new ReformTextService();
    }

    @AfterMethod
    public void tearDown() {
        reformTextService = null;
    }

    @Test
    public void getWordsStringFormatPositiveTest() {
        List<String> words = new ArrayList<>();
        words.add("Book1");
        words.add("Book2");
        words.add("Book3");
        try {
            String actual = reformTextService.getWordsStringFormat(words);
            String expected = "Book1Book2Book3";
            assertEquals(actual, expected, "updateTextPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void getWordsStringFormatNegativeTest() {
        List<String> words = new ArrayList<>();
        words.add("Book1");
        words.add("Book2");
        words.add("Book3");
        try {
            String actual = reformTextService.getWordsStringFormat(words);
            String expected = "Book1 Book 2Book3";
            assertNotEquals(actual, expected, "updateTextNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void getWordsStringFormatExceptionTest() throws IncorrectValueException {
        reformTextService.getWordsStringFormat(null);
    }

    @Test
    public void splitTextOnWordPositiveTest() {
        String text = "hello world";
        List<String> expected = new ArrayList<>();
        expected.add("hello");
        expected.add(" ");
        expected.add("world");
        try {
            List<String> actual = reformTextService.splitTextOnWord(text);
            assertEquals(actual, expected, "splitTextOnWordPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void splitTextOnWordNegativeTest() {
        String text = "hello world";
        List<String> expected = new ArrayList<>();
        expected.add("hello");
        expected.add("  ");
        expected.add("world");
        try {
            List<String> actual = reformTextService.splitTextOnWord(text);
            assertNotEquals(actual, expected, "splitTextOnWordNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void splitTextOnWordExceptionTest() throws IncorrectValueException {
        reformTextService.splitTextOnWord(null);
    }
}