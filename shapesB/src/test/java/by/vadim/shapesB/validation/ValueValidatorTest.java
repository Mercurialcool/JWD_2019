package by.vadim.shapesB.validation;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValueValidatorTest {
    ValueValidator validator;
    @BeforeClass
    public void VolumeValidatorCreate(){
        validator=new ValueValidator();
    }

    @Test
    public void basicLongValidationTest(){

        boolean expected =true;
        boolean actual=validator.isLong("12");
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void basicLongFailValidationTest(){

        boolean expected =false;
        boolean actual=validator.isLong("1-23");
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void NegativeLongValidationTest(){

        boolean expected =true;
        boolean actual=validator.isLong("-123");
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void basicDoubleValidationTest(){

        boolean expected =true;
        boolean actual=validator.isDouble("2.3");
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void basicDoubleFailValidationTest(){

        boolean expected =false;
        boolean actual=validator.isDouble("1-23");
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void NegativeDoubleValidationTest(){

        boolean expected =true;
        boolean actual=validator.isDouble("-123.0");
        Assert.assertEquals(actual,expected);


    }
    @Test
    public void shortDoubleValidationTest(){

        boolean expected =true;
        boolean actual=validator.isDouble("123");
        Assert.assertEquals(actual,expected);


    }
}
