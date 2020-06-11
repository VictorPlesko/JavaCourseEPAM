package test.plesko.lesson1.validator;

import com.plesko.lesson1.validator.NumericalValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumericalValidatorTest {

    NumericalValidator numericalValidator = new NumericalValidator();

    @Test
    public void isPositiveTrueTest() {
        boolean actual = numericalValidator.isPositive(5.0D);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void isPositiveFalseTest() {
        boolean actual = numericalValidator.isPositive(-5.0D);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
