package by.vadim.shapesB.action;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CutTest {
    SplitAction action;
    @BeforeClass
    public void createReader(){
        action =new SplitAction();
    }

    @DataProvider(name = "Tetrahedron-Provider-XoY-Define")
    public Object[][] parameterDefineXoYTestProvider() {


        return new Object[][]{
                {new Tetrahedron(1,new Point(1,2,2),new Point(2,3,-1),
                        new Point(3,4,-1),new Point(2,5,-1)) ,true},
                {new Tetrahedron(2,new Point(1,2,2),new Point(2,3,1),
                        new Point(3,4,1),new Point(2,5,1)), false}
        };
    }
    @Test(dataProvider = "Tetrahedron-Provider-XoY-Define")
    public void CutDefineXoYTest(Tetrahedron tetrahedron, boolean expected){

        boolean actual=action.isCutXoY(tetrahedron);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "Tetrahedron-Provider-XoY")
    public Object[][] parameterXoYTestProvider() {


        return new Object[][]{
                {new Tetrahedron(1,new Point(1,2,2),new Point(2,3,-1),
                        new Point(3,4,-1),new Point(2,5,-1)) ,true},
                {new Tetrahedron(2,new Point(1,2,2),new Point(2,3,1),
                        new Point(3,4,1),new Point(2,5,1)), false}
        };
    }
    @Test(dataProvider = "Tetrahedron-Provider-XoY")
    public void CutXoYTest(Tetrahedron tetrahedron, boolean expected){

        boolean actual=action.isCutXoY(tetrahedron);
        Assert.assertEquals(actual,expected);
    }


    @DataProvider(name = "Tetrahedron-Provider-XoZ")
    public Object[][] parameterXoZTestProvider() {


        return new Object[][]{
                {new Tetrahedron(1,new Point(1,2,2),new Point(2,3,-1),
                        new Point(3,-4,-1),new Point(2,5,-1)) ,true},
                {new Tetrahedron(2,new Point(1,2,2),new Point(2,3,1),
                        new Point(3,4,1),new Point(2,5,1)), false}
        };
    }
    @Test(dataProvider = "Tetrahedron-Provider-XoZ")
    public void CutXoZTest(Tetrahedron tetrahedron, boolean expected){

        boolean actual=action.isCutXoZ(tetrahedron);
        Assert.assertEquals(actual,expected);
    }
    @DataProvider(name = "Tetrahedron-Provider-YoZ")
    public Object[][] parameterYoZTestProvider() {


        return new Object[][]{
                {new Tetrahedron(1,new Point(1,2,2),new Point(2,3,-1),
                        new Point(-3,-4,-1),new Point(2,5,-1)) ,true},
                {new Tetrahedron(2,new Point(1,2,2),new Point(2,3,1),
                        new Point(3,4,1),new Point(2,5,1)), false}
        };
    }
    @Test(dataProvider = "Tetrahedron-Provider-YoZ")
    public void CutYoZTest(Tetrahedron tetrahedron, boolean expected){

        boolean actual=action.isCutYoZ(tetrahedron);
        Assert.assertEquals(actual,expected);
    }
}
