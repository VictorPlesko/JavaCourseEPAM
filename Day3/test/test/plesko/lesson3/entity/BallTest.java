package test.plesko.lesson3.entity;

import com.plesko.lesson3.entity.Ball;
import com.plesko.lesson3.entity.BallColor;
import com.plesko.lesson3.exception.CustomException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BallTest {

    @Test
    public void constructorExceptionColorTest() {
        try {
            Ball actualBall = new Ball(5, 5.2, null);
            fail("An exception is required.");
        } catch (CustomException ex) {
            assertEquals("Invalid parameter", ex.getMessage());
        }
    }

    @Test
    public void constructorExceptionWeightTest() {
        try {
            Ball actualBall = new Ball(-3, 5.2, BallColor.RED);
            fail("An exception is required.");
        } catch (CustomException ex) {
            assertEquals("Invalid parameter", ex.getMessage());
        }
    }

    @Test
    public void constructorExceptionRadiusTest() {
        try {
            Ball actualBall = new Ball(5, 0, BallColor.RED);
            fail("An exception is required.");
        } catch (CustomException ex) {
            assertEquals("Invalid parameter", ex.getMessage());
        }
    }

    @Test
    public void volumeTest() {
        try {
            Ball ball = new Ball(5, 3, BallColor.RED);
            double actual = ball.volume();
            double expected = 113.0973;
            assertEquals(actual, expected, 0.0001);
        } catch (CustomException ex) {
            fail("No exception required.");
        }
    }
}
