package test.plesko.lesson1.service;

import com.plesko.lesson1.service.EvenNumberService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EvenNumberServiceTest {

    EvenNumberService evenNumberService = new EvenNumberService();

    @Test
    public void isTwoAndMoreEvenNumbersTrue() {
        boolean actual = evenNumberService.isTwoAndMoreEvenNumbers(4, 3, 8, 7);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void isTwoAndMoreEvenNumbersFalse() {
        boolean actual = evenNumberService.isTwoAndMoreEvenNumbers(4, 3, 1, 7);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
