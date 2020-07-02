package test.plesko.lesson5.reader;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.reader.ReaderForFile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderForFileTest {

    @Test
    public void readTextTest() {
        ReaderForFile readerForFile = new ReaderForFile();
        try {
            String actual = readerForFile.readText("date.txt");
            String expected = "English texts for beginners to practice reading and " +
                    "comprehension online and for free. Practicing your comprehension " +
                    "of written English will both improve your vocabulary and understanding " +
                    "of grammar and word order. The texts below are designed to help you develop " +
                    "while giving you an instant evaluation of your progress.";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void readTextExceptionTest() {
        ReaderForFile readerForFile = new ReaderForFile();
        try {
            readerForFile.readText(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }
}
