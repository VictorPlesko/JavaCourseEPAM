package test.plesko.lesson1.service;

import com.plesko.lesson1.entity.Point;
import com.plesko.lesson1.exception.CustomException;
import com.plesko.lesson1.service.CoordinateService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CoordinateServiceTest {

    CoordinateService coordinateService = new CoordinateService();

    @Test
    public void findNearestPointZeroTest() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        try {
            int actual = coordinateService.findNearestPoint(point1, point2);
            int expected = 0;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("The points must be equal.");
        }
    }

    @Test
    public void findNearestPointOneTest() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        try {
            int actual = coordinateService.findNearestPoint(point1, point2);
            int expected = 1;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("The first point should be closer.");
        }
    }

    @Test
    public void findNearestPointMinusOneTest() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(1, 2);
        try {
            int actual = coordinateService.findNearestPoint(point1, point2);
            int expected = -1;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("The second point should be closer.");
        }
    }

    @Test
    public void findNearestPointExceptionTest() {
        Point point1 = new Point(-1000, 200);
        Point point2 = new Point(40, 6);
        try {
            coordinateService.findNearestPoint(point1, point2);
            fail("Any point must have an invalid value.");
        } catch (CustomException ex) {
            assertEquals("Invalid value for passed parameters", ex.getMessage());
        }
    }
}
