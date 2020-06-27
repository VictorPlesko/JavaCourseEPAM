package test.plesko.lesson4_2.service;

import com.plesko.lesson4_1.exception.CustomException;
import com.plesko.lesson4_2.service.SortService;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;
import static org.testng.Assert.assertEquals;

public class SortServiceTest {

    int[][] jaggedArray = {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {5, 8, 1, 3},
            {6, -1, 5, -9},
            {1, 1, -3},
            {0},
            {24, 102}
    };

    @Test
    public void sortBySumRowElementsTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.sortBySumRowElements(jaggedArray);
            int[][] expected = {
                    {1, 1, -3},
                    {0},
                    {6, -1, 5, -9},
                    {5, 8, 1, 3},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {24, 102}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void sortBySumRowElementsExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.sortBySumRowElements(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }

    @Test
    public void reverseSortBySumRowElementsTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.reverseSortBySumRowElements(jaggedArray);
            int[][] expected = {
                    {24, 102},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {5, 8, 1, 3},
                    {6, -1, 5, -9},
                    {0},
                    {1, 1, -3}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void reverseSortBySumRowElementsExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.reverseSortBySumRowElements(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }

    @Test
    public void sortByMaximumRowElementTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.sortByMaximumRowElement(jaggedArray);
            int[][] expected = {
                    {0},
                    {1, 1, -3},
                    {6, -1, 5, -9},
                    {5, 8, 1, 3},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {24, 102}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void sortByMaximumRowElementExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.sortByMaximumRowElement(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }

    @Test
    public void reverseSortByMaximumRowElementTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.reverseSortByMaximumRowElement(jaggedArray);
            int[][] expected = {
                    {24, 102},
                    {5, 8, 1, 3},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {6, -1, 5, -9},
                    {1, 1, -3},
                    {0}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void reverseSortByMaximumRowElementExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.reverseSortByMaximumRowElement(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }

    @Test
    public void sortByMinimumRowElementTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.sortByMinimumRowElement(jaggedArray);
            int[][] expected = {
                    {6, -1, 5, -9},
                    {1, 1, -3},
                    {0},
                    {5, 8, 1, 3},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {24, 102}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void sortByMinimumRowElementExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.sortByMinimumRowElement(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }

    @Test
    public void reverseSortByMinimumRowElementTest() {
        SortService sortService = new SortService();
        try {
            int[][] actual = sortService.reverseSortByMinimumRowElement(jaggedArray);
            int[][] expected = {
                    {24, 102},
                    {5, 8, 1, 3},
                    {1, 2, 3, 4, 5, 6, 7, 8},
                    {0},
                    {1, 1, -3},
                    {6, -1, 5, -9}
            };
            assertEquals(actual.length, expected.length);
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual[i], expected[i]);
            }
        } catch (CustomException ex) {
            fail("There should be no exception.");
        }
    }

    @Test
    public void reverseSortByMinimumRowElementExceptionTest() {
        SortService sortService = new SortService();
        try {
            sortService.reverseSortByMinimumRowElement(null);
            fail("Exception required");
        } catch (CustomException ex) {
            assertEquals("Null object.", ex.getMessage());
        }
    }
}
