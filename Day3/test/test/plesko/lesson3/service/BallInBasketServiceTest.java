package test.plesko.lesson3.service;

import com.plesko.lesson3.entity.Ball;
import com.plesko.lesson3.entity.Basket;
import com.plesko.lesson3.entity.BallColor;
import com.plesko.lesson3.exception.CustomException;
import com.plesko.lesson3.service.BallInBasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BallInBasketServiceTest {

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
    public void calculateWeightInBasketTest() {
        BallInBasketService ballInBasketService = new BallInBasketService();
        try {
            double actual = ballInBasketService.calculateWeightInBasket(basket);
            double expected = 2050;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void calculateWeightInBasketExceptionTest() {
        BallInBasketService ballInBasketService = new BallInBasketService();
        try {
            double actual = ballInBasketService.calculateWeightInBasket(null);
            fail("An exception throw is required.");
        } catch (CustomException ex) {
            assertEquals("Invalid function parameter", ex.getMessage());
        }
    }

    @Test
    public void findNumberBallsByColorTest() {
        BallInBasketService ballInBasketService = new BallInBasketService();
        try {
            int actual = ballInBasketService.findNumberBallsByColor(basket, BallColor.BLUE);
            int expected = 2;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void findNumberBallsByColorExceptionTest() {
        BallInBasketService ballInBasketService = new BallInBasketService();
        try {
            int actual = ballInBasketService.findNumberBallsByColor(null, null);
            fail("An exception throw is required.");
        } catch (CustomException ex) {
            assertEquals("Invalid function parameter", ex.getMessage());
        }
    }
}
