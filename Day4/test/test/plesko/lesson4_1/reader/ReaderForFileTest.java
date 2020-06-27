package test.plesko.lesson4_1.reader;

import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.reader.ReaderForFile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderForFileTest {

    @Test
    public void readArrayTest() {
        ReaderForFile readerForFile = new ReaderForFile();
        try {
            String[] actual = readerForFile.readArray("data.txt");
            String[] expected = {"6", "3", "9", "0", "1", "4", "8", "5", "7", "2", "-4", "10"};
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void readArrayExceptionTest() {
        ReaderForFile readerForFile = new ReaderForFile();
        try {
            readerForFile.readArray(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }
}
