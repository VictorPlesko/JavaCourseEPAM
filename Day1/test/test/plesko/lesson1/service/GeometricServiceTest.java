package test.plesko.lesson1.service;

import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.GeometricService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class GeometricServiceTest {

    GeometricService geometricService = new GeometricService();

    @Test
    public void calculateAreaInscribedSquareTest() {
        try {
            double actual = geometricService.calculateAreaInscribedSquare(5.0D);
            double expected = 2.5D;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void calculateAreaInscribedSquareExceptionTest() {
        try {
            geometricService.calculateAreaInscribedSquare(-1D);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("The value of the area must be positive.", ex.getMessage());
        }
    }

    @Test
    public void calculateSquareDifferenceTest() {
        try {
            double actual = geometricService.calculateSquareDifference(5.0D, 2.5D);
            double expected = 2D;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void calculateSquareDifferenceExceptionTest() {
        try {
            geometricService.calculateSquareDifference(-5.0D, 2.5D);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("The value of the area must be positive.", ex.getMessage());
        }
    }

    @Test
    public void calculateCircumferenceTest() {
        try {
            double actual = geometricService.calculateCircumference(5.0D);
            double expected = 31.41593D;
            assertEquals(actual, expected, 0.00001);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void calculateCircumferenceExceptionTest() {
        try {
            geometricService.calculateCircumference(-5.0D);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("Radius must be positive.", ex.getMessage());
        }
    }

    @Test
    public void calculateCircleAreaTest() {
        try {
            double actual = geometricService.calculateCircleArea(5.0D);
            double expected = 78.53982D;
            assertEquals(actual, expected, 0.00001);
        } catch (CustomException ex) {
            fail("Valid value required.");
        }
    }

    @Test
    public void calculateCircleAreaExceptionTest() {
        try {
            geometricService.calculateCircleArea(-5.0D);
            fail("Exception expected.");
        } catch (CustomException ex) {
            assertEquals("Radius must be positive.", ex.getMessage());
        }
    }
}
