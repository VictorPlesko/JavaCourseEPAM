package test.plesko.lesson1.service;

import com.plesko.lesson1.service.LastDigitSquareService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LastDigitSquareServiceTest {

    LastDigitSquareService lastDigitSquareService = new LastDigitSquareService();

    @Test
    public void calculateDigitTest() {
        int actual = lastDigitSquareService.calculateDigit(889);
        int expected = 1;
        assertEquals(actual, expected);
    }
}
