package by.vadim.shapesB.validation;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class StringValidationTest {
    StringValidator validator;
    @BeforeClass
    public void VolumeValidatorCreate(){
        validator=new StringValidator();
    }

   @Test
   public void basicStringValidationTest(){
       boolean expected =true;
       List<String> list=List.of("7",
               "2.0",
               "1.0",
               "2.0",
               "0.0",
               "1.0",
               "1.0",
               "2.0",
               "1.0",
               "1.0",
               "2.0",
               "2.0",
               "1.0"
               );
       boolean actual=validator.validateTetrahedronLine(list);
       Assert.assertEquals(actual,expected);


   }
    @Test
    public void badIdStringValidationTest(){
        boolean expected =false;
        List<String> list=List.of("-7a",
                "2.0",
                "1.0",
                "2.0",
                "0.0",
                "1.0",
                "1.0",
                "2.0",
                "1.0",
                "1.0",
                "2.0",
                "2.0",
                "1.0"
        );
        Assert.assertFalse(validator.validateTetrahedronLine(list));


    }
}
