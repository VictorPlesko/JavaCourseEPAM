package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.impl.RegexRemoveImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegexRemoveImplTest {

    String text = "English texts for beginners to practice reading and " +
            "comprehension online and for free. Practicing your comprehension of written English will " +
            "both improve your vocabulary and understanding of grammar and word order. " +
            "The texts below are designed to help you develop while giving you an instant evaluation of your progress.";

    @Test
    public void deleteAllCharactersNotLetterTest() throws CustomException {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        String actual = regexRemove.deleteAllCharactersNotLetter(text);
        String expected = "English texts for beginners to practice reading and comprehension " +
                "online and for free  Practicing your comprehension of written English will " +
                "both improve your vocabulary and understanding of grammar and word order  The " +
                "texts below are designed to help you develop while giving you an instant evaluation" +
                " of your progress ";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void deleteAllCharactersNotLetterExceptionTest() throws CustomException {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        regexRemove.deleteAllCharactersNotLetter(null);
    }

    @Test
    public void deleteWordBeginningWithConsonantTest() throws CustomException {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        String actual = regexRemove.deleteWordBeginningWithConsonant(text, 5);
        String expected = "English  for beginners to practice reading and " +
                "comprehension online and for free. Practicing your comprehension of" +
                " written English will both improve your vocabulary and understanding of" +
                " grammar and word order. The   are designed to help you develop " +
                " giving you an instant evaluation of your progress.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void deleteWordBeginningWithConsonantExceptionTest() throws CustomException {
        RegexRemoveImpl regexRemove = new RegexRemoveImpl();
        regexRemove.deleteWordBeginningWithConsonant(null, -1);
    }
}
