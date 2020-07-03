package test.plesko.lesson5.service.impl;

import com.plesko.lesson5.exception.CustomException;
import com.plesko.lesson5.service.impl.StringReplacementImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringReplacementImplTest {

    String text = "English texts for beginners to practice reading and " +
            "comprehension online and for free. Practicing your comprehension of written English will " +
            "both improve your vocabulary and understanding of grammar and word order. " +
            "The texts below are designed to help you develop while giving you an instant evaluation of your progress.";

    @Test
    public void replaceLetterByIndexTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        String actual = stringReplacement.replaceLetterByIndex(text, 6, 'G');
        String expected = "EnglisG texts for beginnGrs to practiGe readinG and compreGension online and for free. " +
                "PractiGing your compreGension of writteG EnglisG will both improvG your " +
                "vocabuGary and undersGanding of grammaG and word order. The texts below are " +
                "designGd to help you develoG while giving you an instanG evaluaGion of your progreGs.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void replaceLetterByIndexExceptionTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        stringReplacement.replaceLetterByIndex(null, -1, 'f');
    }

    @Test
    public void replaceMistakeTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        String actual = stringReplacement.replaceMistake(text, 'p', 'r', 't');
        String expected = "English texts for beginners to ptactice reading and comptehension online and for free." +
                " Practicing your comptehension of written English will both imptove your vocabulary and " +
                "understanding of grammar and word order. The texts below are designed to help you develop while " +
                "giving you an instant evaluation of your ptogress.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void replaceMistakeExceptionTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        stringReplacement.replaceMistake(null, 'p', 'r', 't');
    }

    @Test
    public void replaceWordWithSubstringTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        String actual = stringReplacement.replaceWordWithSubstring(text, 4, "abc");
        String expected = "English texts for beginners to practice reading and comprehension online and for free." +
                " Practicing abc comprehension of written English abc abc improve abc vocabulary and understanding" +
                " of grammar and abc order. The texts below are designed to abc you develop while" +
                " giving you an instant evaluation of abc progress.";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void replaceWordWithSubstringExceptionTest() throws CustomException {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        stringReplacement.replaceWordWithSubstring(null, 1, null);
    }
}
