package test.plesko.lesson4_1.validator;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.validator.ArrayValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArrayValidatorTest {

    @Test
    public void isSortedTrueTest() {
        ArrayValidator arrayValidator = new ArrayValidator();
        try {
            OneDimensionalArray oneDimensionalArray = new OneDimensionalArray(1, 2, 3, 4, 5, 6);
            boolean actual = arrayValidator.isSorted(oneDimensionalArray);
            boolean expected = true;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void isSortedFalseTest() {
        ArrayValidator arrayValidator = new ArrayValidator();
        try {
            OneDimensionalArray oneDimensionalArray = new OneDimensionalArray(3, 2, 4, 4, 6, 6);
            boolean actual = arrayValidator.isSorted(oneDimensionalArray);
            boolean expected = false;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }
}
