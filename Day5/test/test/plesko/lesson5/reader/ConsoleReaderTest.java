package test.plesko.lesson5.reader;

import com.plesko.lesson5.reader.ConsoleReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConsoleReaderTest {

    @Test
    public void readTextTest(){
        ConsoleReader consoleReader = new ConsoleReader();
        String actual = consoleReader.readText();
        String expected = "qwerty";
        assertEquals(actual, expected);
    }
}
