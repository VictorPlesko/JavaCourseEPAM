package test.plesko.lesson3.entity;

import com.plesko.lesson3.entity.Ball;
import com.plesko.lesson3.entity.Basket;
import com.plesko.lesson3.entity.BallColor;
import com.plesko.lesson3.exception.CustomException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketTest {

    Basket basket;

    @BeforeClass
    public void setUp() {
        basket = new Basket(8300);
        try {
            basket.add(new Ball(310, 5, BallColor.RED));
            basket.add(new Ball(240, 4.5, BallColor.BLUE));
            basket.add(new Ball(542, 6.1, BallColor.BLUE));
            basket.add(new Ball(432, 4.5, BallColor.YELLOW));
            basket.add(new Ball(526, 5.3, BallColor.VIOLET));
        } catch (CustomException ex) {
            fail("Initialization error");
        }
    }

    @Test
    public void addTest() {
        try {
            boolean actual = basket.add(new Ball(210, 2.5, BallColor.BLUE));
            boolean expected = true;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("No exception required");
        }
    }

    @Test
    public void addExceptionMoreVolumeTest() {
        try {
            boolean actual = basket.add(new Ball(1230, 30, BallColor.BLUE));
            boolean expected = false;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("No exception required");
        }
    }

    @Test
    public void addExceptionNullTest() {
        boolean actual = basket.add(null);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
