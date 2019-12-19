package by.vadim.shapesB.parser;

import by.vadim.shapesB.reader.TetrahedronReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    TetrahedronParser parser;
    @BeforeClass
    public void createReader(){
        parser =new TetrahedronParser();
    }
    @DataProvider(name = "Lines-Provider-Function")
    public Object[][] parameterIntTestProvider() {

        List<String> parameters1=List.of("7 2.0 1.0 2.0 0.0 1.0 1.0 2.0 1.0 1.0 2.0 2.0 1.0");
        List<String> parameters2=List.of("7 2.0 1.0 2.0 0.0 1.0 1.0 2.0 1.0 1.0 2.0 2.0 1.0",
                "7 2.0 1.0 3.0 0.0 1.0 1.0 2.0 1.0 1.0 2.0 2.0 1.0",
                "7 2.0 1.0 a.0 0.0 1.0 1.0 2.0 1.0 1.0 2.0 2.0 1.0");

        return new Object[][]{
                {parameters1 ,1},
                {parameters2, 2}
        };
    }
    @Test(dataProvider = "Lines-Provider-Function")
    public void NegativeReadLineTest(List<String> lines,int expected){

        int actual=parser.parse(lines).size();
        Assert.assertEquals(actual,expected);
    }


}
