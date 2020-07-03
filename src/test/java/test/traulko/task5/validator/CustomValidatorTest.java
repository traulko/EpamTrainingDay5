package test.traulko.task5.validator;

import com.traulko.task5.validator.CustomValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CustomValidatorTest {
    CustomValidator customValidator;

    @BeforeMethod
    public void setUp() {
        customValidator = new CustomValidator();
    }

    @AfterMethod
    public void tearDown() {
        customValidator = null;
    }

    @Test
    public void isCorrectSymbolPositiveTest() {
        boolean actual = customValidator.isCorrectSymbol(21);
        assertTrue(actual, "isCorrectSymbolPositiveTest failed as...");
    }

    @Test
    public void isCorrectSymbolNegativeTest() {
        boolean actual = customValidator.isCorrectSymbol(-156);
        assertFalse(actual, "isCorrectSymbolNegativeTest failed as...");
    }
}