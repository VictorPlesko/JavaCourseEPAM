package test.plesko.lesson4_1.reader;

import com.plesko.lesson4_1.reader.ConsoleReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConsoleReaderTest {

    @Test
    public void readArrayTest() {
        ConsoleReader consoleReader = new ConsoleReader();
        String[] actual = consoleReader.readArray();
        String[] expected = {"6", "3", "9", "0", "1", "4", "8", "5", "7", "2", "-4", "10"};
        assertEquals(actual, expected);
    }
}
