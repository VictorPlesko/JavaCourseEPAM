package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import com.plesko.lesson5.service.impl.CharArrayReplacementImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CharArrayReplacementImplTest {

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
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            String actual = charArrayReplacement.replaceLetterByIndex(text, 6, 'G');
            String expected = "EnglisG texts for beginnGrs to practiGe readinG and compreGension online and for free. " +
                    "PractiGing your compreGension of writteG EnglisG will both improvG your " +
                    "vocabuGary and undersGanding of grammaG and word order. The texts below are " +
                    "designGd to help you develoG while giving you an instanG evaluaGion of your progreGs.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail();
        }
    }

    @Test
    public void replaceLetterByIndexExceptionTest() {
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            charArrayReplacement.replaceLetterByIndex(null, -1, 'f');
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void replaceMistakeTest() {
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            String actual = charArrayReplacement.replaceMistake(text, 'p', 'r', 't');
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
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            charArrayReplacement.replaceMistake(null, 'p', 'r', 't');
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }

    @Test
    public void replaceWordWithSubstringTest() {
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            String actual = charArrayReplacement.replaceWordWithSubstring(text, 4, "abc");
            String expected = "English texts for beginners to practice reading and comprehension online and for free." +
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
        CharArrayReplacementImpl charArrayReplacement = new CharArrayReplacementImpl();
        try {
            charArrayReplacement.replaceWordWithSubstring(null, 1, null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid parameters", ex.getMessage());
        }
    }
}
