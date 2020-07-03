package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.impl.StringRemoveImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringRemoveImplTest {

    String text = "English texts for beginners to practice reading and " +
            "comprehension online and for free. Practicing your comprehension of written English will " +
            "both improve your vocabulary and understanding of grammar and word order. " +
            "The texts below are designed to help you develop while giving you an instant evaluation of your progress.";

    @Test
    public void deleteAllCharactersNotLetterTest() throws CustomException {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        String actual = stringRemove.deleteAllCharactersNotLetter(text);
        String expected = "English texts for beginners to practice reading and comprehension " +
                "online and for free  Practicing your comprehension of written English will " +
                "both improve your vocabulary and understanding of grammar and word order  The " +
                "texts below are designed to help you develop while giving you an instant evaluation" +
                " of your progress ";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void deleteAllCharactersNotLetterExceptionTest() throws CustomException {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        stringRemove.deleteAllCharactersNotLetter(null);
    }

    @Test
    public void deleteWordBeginningWithConsonantTest() throws CustomException {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        String actual = stringRemove.deleteWordBeginningWithConsonant(text, 4);
        String expected = "English texts for beginners to practice reading and comprehension " +
                "online and for free. Practicing comprehension of written English " +
                "improve vocabulary and understanding of grammar and order. The " +
                "texts below are designed to you develop while giving you an instant evaluation" +
                " of progress.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void deleteWordBeginningWithConsonantExceptionTest() throws CustomException {
        StringRemoveImpl stringRemove = new StringRemoveImpl();
        stringRemove.deleteWordBeginningWithConsonant(null, -1);
    }
}
