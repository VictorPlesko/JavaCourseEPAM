package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import com.plesko.lesson5.service.impl.CharArrayRemoveImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CharArrayRemoveImplTest {

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
        CharArrayRemoveImpl charArrayRemove = new CharArrayRemoveImpl();
        try {
            String actual = charArrayRemove.deleteAllCharactersNotLetter(text);
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
        CharArrayRemoveImpl charArrayRemove = new CharArrayRemoveImpl();
        try {
            charArrayRemove.deleteAllCharactersNotLetter(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void deleteWordBeginningWithConsonantTest() {
        CharArrayRemoveImpl charArrayRemove = new CharArrayRemoveImpl();
        try {
            String actual = charArrayRemove.deleteWordBeginningWithConsonant(text, 4);
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
        CharArrayRemoveImpl charArrayRemove = new CharArrayRemoveImpl();
        try {
            charArrayRemove.deleteWordBeginningWithConsonant(null, -1);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }
}
