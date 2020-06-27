package test.plesko.lesson4_1.creator;

import com.plesko.lesson4_1.creator.ArrayCreator;
import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArrayCreatorService {

    @Test
    public void arrayFromFile() {
        ArrayCreator arrayCreator = new ArrayCreator();
        try {
            OneDimensionalArray actual = arrayCreator.arrayFromFile("data.txt");
            OneDimensionalArray expected = new OneDimensionalArray(6, 3, 9, 0, 1, 4, 8, 5, 7, 2, -4, 10);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }

    @Test
    public void arrayFromConsole() {
        ArrayCreator arrayCreator = new ArrayCreator();
        try {
            OneDimensionalArray actual = arrayCreator.arrayFromConsole();
            OneDimensionalArray expected = new OneDimensionalArray(6, 3, 9, 0, 1, 4, 8, 5, 7, 2, -4, 10);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Exception not expected");
        }
    }
}
