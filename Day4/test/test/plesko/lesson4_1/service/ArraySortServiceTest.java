package test.plesko.lesson4_1.service;

import com.plesko.lesson4_1.entity.OneDimensionalArray;
import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_1.service.ArraySortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArraySortServiceTest {

    OneDimensionalArray oneDimensionalArray;

    @BeforeClass
    public void setUp() {
        try {
            oneDimensionalArray = new OneDimensionalArray(6, 3, 9, 0, 1, 4, 8, 5, 7, 2, -4, 10);
        } catch (CustomException ex) {
            ex.getMessage();
        }
    }

    @Test
    public void bubbleSortTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            OneDimensionalArray actual = arraySortService.bubbleSort(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(-4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void bubbleSortExceptionTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            arraySortService.bubbleSort(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void selectionSortTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            OneDimensionalArray actual = arraySortService.selectionSort(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(-4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void selectionSortExceptionTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            arraySortService.selectionSort(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }

    @Test
    public void shuttleSortTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            OneDimensionalArray actual = arraySortService.shuttleSort(oneDimensionalArray);
            OneDimensionalArray expected = new OneDimensionalArray(-4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            assertEquals(actual, expected);
        } catch (CustomException ex) {
            fail("There should be no exceptions");
        }
    }

    @Test
    public void shuttleSortExceptionTest() {
        ArraySortService arraySortService = new ArraySortService();
        try {
            arraySortService.selectionSort(null);
            fail("Exception expected");
        } catch (CustomException ex) {
            assertEquals("Null object", ex.getMessage());
        }
    }
}
