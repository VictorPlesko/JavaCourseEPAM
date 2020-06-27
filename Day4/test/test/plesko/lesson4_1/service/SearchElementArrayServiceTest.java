package test.plesko.lesson4_1.service;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.service.SearchElementArrayService;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchElementArrayServiceTest {

    OneDimensionalArray oneDimensionalArray;

    @Test
    public void binarySearchTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(-2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 32);
            int actual = searchElementArrayService.binarySearch(oneDimensionalArray, 5);
            int expected = 5;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void binarySearchMinusOneTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(-2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 32);
            int actual = searchElementArrayService.binarySearch(oneDimensionalArray, -6);
            int expected = -1;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void binarySearchExceptionNotSortedTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(-2, 6, 6, 32, 2, 1, 0, 4, 9, 6, 43, 11, 32);
            searchElementArrayService.binarySearch(oneDimensionalArray, 5);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid array", ex.getMessage());
        }
    }

    @Test
    public void binarySearchExceptionNullTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.binarySearch(null, 5);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Invalid array", ex.getMessage());
        }
    }

    @Test
    public void maxValueTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(43, 32, 6, 213, 4, 6, 32, 43, 78, -62, 11, -263, -43);
            int actual = searchElementArrayService.maxValue(oneDimensionalArray);
            int expected = 213;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void maxValueExceptionTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.maxValue(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void minValueTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(43, 32, 6, 213, 4, 6, 32, 43, 78, -62, 11, -263, -43);
            int actual = searchElementArrayService.minValue(oneDimensionalArray);
            int expected = -263;
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void minValueExceptionTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.minValue(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void findPrimeNumberTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(43, 32, 6, 211, 4, 6, 32, 47, 78, -62, 11, -263, -43);
            OneDimensionalArray actual = searchElementArrayService.findPrimeNumber(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(43, 211, 47, 11, -263, -43);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void findPrimeNumberExceptionTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.findPrimeNumber(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void findFibonacciNumberTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(1, 32, 13, 232, 233, 8, -3, 0, 89, 10946, 11, 21, -43);
            OneDimensionalArray actual = searchElementArrayService.findFibonacciNumber(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(1, 13, 233, 8, 89, 10946, 21);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void findPrimeFibonacciExceptionTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.findFibonacciNumber(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void findNumberWithoutRepeatingNumbersTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            oneDimensionalArray = new OneDimensionalArray(1, 32, 132, 232, 263, 8, -321, 432, 890, 10946, 2318, -217, -43);
            OneDimensionalArray actual = searchElementArrayService.findNumberWithoutRepeatingNumbers(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(132, 263, -321, 432, 890, -217);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void findNumberWithoutRepeatingNumbersExceptionTest() {
        SearchElementArrayService searchElementArrayService = new SearchElementArrayService();
        try {
            searchElementArrayService.findNumberWithoutRepeatingNumbers(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }
}
