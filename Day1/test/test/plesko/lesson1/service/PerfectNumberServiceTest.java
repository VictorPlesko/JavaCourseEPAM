package test.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.PerfectNumberService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class PerfectNumberServiceTest {

    PerfectNumberService perfectNumberService = new PerfectNumberService();

    @Test
    public void isPerfectNumberTrueTest() {
        try {
            boolean actual = perfectNumberService.isPerfectNumber(496);
            boolean expected = true;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void isPerfectNumberFalseTest() {
        try {
            boolean actual = perfectNumberService.isPerfectNumber(321);
            boolean expected = false;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void isPerfectNumberExceptionTest() {
        try {
            perfectNumberService.isPerfectNumber(-28);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("The number must be positive.", ex.getMessage());
        }
    }
}
