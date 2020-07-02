package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import com.plesko.lesson5.service.impl.StringRemoveImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class StringRemoveImplTest {

    String text;

    @BeforeTest
    public void setUp() {
        ReaderForFile readerForFile = new ReaderForFile();
        try {
            text = readerForFile.readText("date.txt");
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void deleteAllCharactersNotLetterTest() {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        try {
            String actual = stringRemove.deleteAllCharactersNotLetter(text);
            String expected = "English texts for beginners to practice reading and comprehension " +
                    "online and for free  Practicing your comprehension of written English will " +
                    "both improve your vocabulary and understanding of grammar and word order  The " +
                    "texts below are designed to help you develop while giving you an instant evaluation" +
                    " of your progress ";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void deleteAllCharactersNotLetterExceptionTest() {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        try {
            stringRemove.deleteAllCharactersNotLetter(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void deleteWordBeginningWithConsonantTest() {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        try {
            String actual = stringRemove.deleteWordBeginningWithConsonant(text, 4);
            String expected = "English texts for beginners to practice reading and comprehension " +
                    "online and for free. Practicing comprehension of written English " +
                    "improve vocabulary and understanding of grammar and order. The " +
                    "texts below are designed to you develop while giving you an instant evaluation" +
                    " of progress.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void deleteWordBeginningWithConsonantExceptionTest() {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        try {
            stringRemove.deleteWordBeginningWithConsonant(null, -1);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }
}
