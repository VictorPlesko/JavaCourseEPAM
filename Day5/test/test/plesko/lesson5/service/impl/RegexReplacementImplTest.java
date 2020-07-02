package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import com.plesko.lesson5.service.impl.RegexReplacementImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class RegexReplacementImplTest {

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
    public void replaceLetterByIndexTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            String actual = regexReplacement.replaceLetterByIndex(text, 6, 'G');
            String expected = "EnglisG texts for beginnGrs to practiGe readinG and compreGension online and for free. " +
                    "PractiGing your compreGension of writteG EnglisG will both improvG your " +
                    "vocabuGary and undersGanding of grammaG and word order. The texts below are " +
                    "designGd to help you develoG while giving you an instanG evaluaGion of your progreGs.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void replaceLetterByIndexExceptionTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            regexReplacement.replaceLetterByIndex(null, -1, 'f');
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void replaceMistakeTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            String actual = regexReplacement.replaceMistake(text, 'p', 'r', 't');
            String expected = "English texts for beginners to ptactice reading and comptehension online and for free." +
                    " Practicing your comptehension of written English will both imptove your vocabulary and " +
                    "understanding of grammar and word order. The texts below are designed to help you develop while " +
                    "giving you an instant evaluation of your ptogress.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void replaceMistakeExceptionTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            regexReplacement.replaceMistake(null, 'p', 'r', 't');
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void replaceWordWithSubstringTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            String actual = regexReplacement.replaceWordWithSubstring(text, 4, "abc");
            String expected = "English texts for beginners to practice reading and comprehension online and for abc." +
                    " Practicing abc comprehension of written English abc abc improve abc vocabulary and understanding" +
                    " of grammar and abc order. The texts below are designed to abc you develop while" +
                    " giving you an instant evaluation of abc progress.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void replaceWordWithSubstringExceptionTest() {
        RegexReplacementImpl regexReplacement = new RegexReplacementImpl();
        try {
            regexReplacement.replaceWordWithSubstring(null, 1, null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }
}
