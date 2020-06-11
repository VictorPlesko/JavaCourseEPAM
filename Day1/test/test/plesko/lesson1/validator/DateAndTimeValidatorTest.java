package test.plesko.lesson1.validator;

import com.plesko.lesson1.validator.DateAndTimeValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DateAndTimeValidatorTest {

    DateAndTimeValidator dateAndTimeValidator = new DateAndTimeValidator();

    @Test
    public void checkMonthTrueTest() {
        boolean actual = dateAndTimeValidator.checkMonth(6);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void checkMonthFalseLessOneTest() {
        boolean actual = dateAndTimeValidator.checkMonth(0);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkMonthFalseMoreTwelveTest() {
        boolean actual = dateAndTimeValidator.checkMonth(13);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkYearTrueTest() {
        boolean actual = dateAndTimeValidator.checkYear(1256);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void checkYearFalseTest() {
        boolean actual = dateAndTimeValidator.checkYear(-2);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkSecondTrueTest() {
        boolean actual = dateAndTimeValidator.checkSecond(4123);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void checkSecondFalseLessOneTest() {
        boolean actual = dateAndTimeValidator.checkSecond(-4);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkSecondFalseMoreSecondInDayTest() {
        boolean actual = dateAndTimeValidator.checkSecond(93231);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
