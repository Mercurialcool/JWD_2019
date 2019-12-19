package by.vadim.shapesB.reader;

import by.vadim.shapesB.exeption.WrongFileInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TetrahedronReaderTest {
    private static final String PATH="input\\dataForTest.txt";
    TetrahedronReader reader;
    @BeforeClass
    public void createReader(){
         reader =new TetrahedronReader();
    }
    @Test
    public void basicReadLineTest(){
        int expected = 2;
        List<String> actual= null;
        try {
            actual = reader.readAllLine(PATH);
        } catch (WrongFileInputException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(actual.size(),expected);
    }
    @Test(expectedExceptions = { WrongFileInputException.class })
    public void NegativeReadLineTest() throws WrongFileInputException {
        int expected = 0;
        List<String> actual= null;
        try {
            actual = reader.readAllLine("\\data\\dta.txt");
        } catch (WrongFileInputException e) {
            throw e;
        }
        Assert.assertEquals(actual.size(),expected);
    }
}
