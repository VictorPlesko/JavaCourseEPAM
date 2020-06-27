package test.plesko.lesson4_1.parser;

import com.plesko.lesson4_1.parser.ArrayParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayParserTest {

    @Test
    public void parseToIntegerArrayTest() {
        ArrayParser arrayParser = new ArrayParser();
        String[] strArray = {"1", "2", "3", "-4"};
        int[] actual = arrayParser.parseToIntegerArray(strArray);
        int[] expected = {1, 2, 3, -4};
        Assert.assertEquals(actual, expected);
    }
}
