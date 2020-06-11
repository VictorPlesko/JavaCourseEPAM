package test.plesko.lesson1.validator;

import com.plesko.lesson1.entity.Point;
import com.plesko.lesson1.validator.PointValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PointValidatorTest {

    PointValidator pointValidator = new PointValidator();

    @Test
    public void checkPointTrueTest() {
        Point point = new Point(23, -41);
        boolean actual = pointValidator.checkPoint(point);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void checkPointFalseMoreMaxXTest() {
        Point point = new Point(150, -41);
        boolean actual = pointValidator.checkPoint(point);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkPointFalseLessMinXTest() {
        Point point = new Point(-123, -41);
        boolean actual = pointValidator.checkPoint(point);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkPointFalseMoreMaxYTest() {
        Point point = new Point(31, 123);
        boolean actual = pointValidator.checkPoint(point);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void checkPointFalseLessMinYTest() {
        Point point = new Point(-23, -231);
        boolean actual = pointValidator.checkPoint(point);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
