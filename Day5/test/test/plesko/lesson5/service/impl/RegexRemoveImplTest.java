package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import com.plesko.lesson5.service.impl.RegexRemoveImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class RegexRemoveImplTest {

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
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        try {
            String actual = regexRemove.deleteAllCharactersNotLetter(text);
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
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        try {
            regexRemove.deleteAllCharactersNotLetter(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void deleteWordBeginningWithConsonantTest() {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        try {
            String actual = regexRemove.deleteWordBeginningWithConsonant(text, 5);
            String expected = "English  for beginners to practice reading and " +
                    "comprehension online and for free. Practicing your comprehension of" +
                    " written English will both improve your vocabulary and understanding of" +
                    " grammar and word order. The   are designed to help you develop " +
                    " giving you an instant evaluation of your progress.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void deleteWordBeginningWithConsonantExceptionTest() {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        try {
            regexRemove.deleteWordBeginningWithConsonant(null, -1);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }
}
