package by.vadim.shapesB.action;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.exeption.LessThanZeroException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DefineTest {
    TetrahedronValuesUpdater action;

    @BeforeClass
    public void createReader() {
        action = new TetrahedronValuesUpdater();
    }

    @DataProvider(name = "Tetrahedron-Provider")
    public Object[][] parameterDefineXoYTestProvider() {


        return new Object[][]{
                {new Tetrahedron(1, new Point(0, 0, 1), new Point(0, 0, 0),
                        new Point(0, 1, 0), new Point(1, 0, 0))},

        };
    }

    @Test(dataProvider = "Tetrahedron-Provider")
    public void defineVolumeTest(Tetrahedron tetrahedron) {
        double expected = 0.17;
        double actual = 0;
        try {
            actual = action.defineVolume(tetrahedron);
        } catch (LessThanZeroException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test(dataProvider = "Tetrahedron-Provider")
    public void definePerimeterTest(Tetrahedron tetrahedron) {
        double expected = 7.24;
        double actual;

        actual = action.definePerimeter(tetrahedron);
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test(dataProvider = "Tetrahedron-Provider")
    public void defineSurfaceAreaTest(Tetrahedron tetrahedron) {
        double expected = 2.37;
        double actual;
        actual = action.defineSurfaceArea(tetrahedron);

        Assert.assertEquals(actual, expected,0.01);
    }

}
