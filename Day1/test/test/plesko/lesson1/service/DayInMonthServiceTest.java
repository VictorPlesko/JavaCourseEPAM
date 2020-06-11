package test.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.DayInMonthService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DayInMonthServiceTest {

    DayInMonthService dayInMonthService = new DayInMonthService();

    @Test
    public void findNumberDaysTest() {
        try {
            int actual = dayInMonthService.findNumberDays(2, 2000);
            int expected = 29;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void findNumberDaysExceptionTest() {
        try {
            dayInMonthService.findNumberDays(14, 2000);
            fail("An exception was expected.");
        } catch (CustomException ex) {
            assertEquals("Invalid value for passed parameters", ex.getMessage());
        }
    }
}
