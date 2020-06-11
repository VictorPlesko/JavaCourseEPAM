package test.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.CustomFunctionService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomFunctionServiceTest {

    CustomFunctionService customFunctionService = new CustomFunctionService();

    @Test
    public void calculateSimpleFunctionMoreThreeTest() {
        double actual = customFunctionService.calculateSimpleFunction(5);
        double expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateSimpleFunctionLessThreeTest() {
        double actual = customFunctionService.calculateSimpleFunction(1);
        double expected = -0.2;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateTangentFunctionTest() {
        try {
            double[][] actual = customFunctionService.calculateTangentFunction(5, 10, 2);
            double[][] expected = {{5, 7, 9}, {-3.38052, 0.871448, -0.452316}};
            assertEquals(expected.length, actual.length);
            for (int i = 0; i < actual.length; i++) {
                for (int j = 0; j < actual[i].length; j++) {
                    assertEquals(actual[i][j], expected[i][j], 0.00001);
                }
            }
        } catch (CustomException ex) {
            fail("Exception thrown.");
        }
    }

    @Test
    public void calculateTangentFunctionExceptionTest() {
        try {
            customFunctionService.calculateTangentFunction(5, 10, 0);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("The step must be positive", ex.getMessage());
        }
    }

}
