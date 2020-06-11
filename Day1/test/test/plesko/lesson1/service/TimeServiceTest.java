package test.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.TimeService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TimeServiceTest {

    TimeService timeService = new TimeService();

    @Test
    public void calculateFullTimeTest() {
        try {
            String actual = timeService.calculateFullTime(42872);
            String expected = "11:54:32";
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void calculateFullTimeExceptionTest() {
        try {
            timeService.calculateFullTime(-3231);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("The number of seconds must be non-negative.", ex.getMessage());
        }
    }
}
